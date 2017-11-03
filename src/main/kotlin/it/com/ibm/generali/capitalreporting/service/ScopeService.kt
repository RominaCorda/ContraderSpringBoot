package it.com.ibm.generali.capitalreporting.service

import it.com.ibm.generali.capitalreporting.dao.ScopeDao
import it.com.ibm.generali.capitalreporting.model.Report
import it.com.ibm.generali.capitalreporting.model.Scope
import it.com.ibm.generali.capitalreporting.model.ScopeType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
open class ScopeService
{
    @Autowired
    lateinit var scopes: ScopeDao

    /**
     * Get the list of all parents of the given scope
     * @return Ordered list of scope's parents
     */
    fun getParents(scope: Scope): LinkedList<Scope>
    {
        var parent: Scope? = scope
        val parents = LinkedList<Scope>()
        while (parent != null)
        {
            parents.add(parent)
            parent = this.scopes.findOne(parent.parent)
        }
        return parents
    }

    /**
     * Gets a description of the scope's parents
     * @return A string of scope's parents divided by |
     */
    fun getParentsDescription(scope: Scope): String
    {
        val parents = this.getParents(scope).reversed()
        return parents.joinToString(" | ")
    }

    fun getChildren(scope: Scope): List<Scope>?
    {
        return this.scopes.findByParent(scope.id)
    }

    fun getSiblings(scope: Scope): LinkedList<Scope>
    {
        val siblings = LinkedList<Scope>()
        val parent: Scope? = this.scopes.findOne(scope.parent)
        val tempSiblings = if (parent != null)
        {
            // Siblings have the same parent
            this.scopes.findByParent(parent.id)
        }
        else
        {
            // Level 0 have no parents
            this.getRoots(scope.type)
        }
        tempSiblings.forEach { s -> siblings.add(s) }
        return siblings
    }

    fun getLevel(scope: Scope): Int
    {
        return this.getParents(scope).size - 1
    }

    fun hasChildren(scope: Scope): Boolean
    {
        val children = this.getChildren(scope)
        if (children != null)
        {
            if (children.isNotEmpty())
                return true
        }
        return false
    }

    /**
     * Get a list of reports with
     * a description of the parent scopes
     * @return a Map of (report -> description)
     */
    fun getScopedReports(reports: List<Report>): HashMap<Report, String>
    {
        val scopedReports = HashMap<Report, String>()
        reports.forEach { report ->
            val description = this.getParentsDescription(report.scope)
            scopedReports[report] = description
        }
        return scopedReports
    }

    fun canAddReports(scope: Scope): Boolean
    {
        if (this.hasChildren(scope))
            return false

        return true
    }

    fun copyScope(scopeKey: Long): Long
    {
        val scope = this.scopes.findOne(scopeKey)
        val scopeCopy = scope.copy()
        this.scopes.save(scopeCopy)
        getChildren(scope)?.forEach {
            children ->
                val childrenId = copyScope(children.id)
                val childrenScope = this.scopes.findOne(childrenId)
                childrenScope.parent = scopeCopy.id
                this.scopes.save(childrenScope)
        }
        return scopeCopy.id
    }

    /**
     * Get all root scopes.
     * A root scope is a scope without parent.
     */
    fun getRoots(type: ScopeType): List<Scope>
    {
        return this.scopes.findByTypeAndParent(type, -1L)
    }


}