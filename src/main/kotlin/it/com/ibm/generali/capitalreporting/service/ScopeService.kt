package it.com.ibm.generali.capitalreporting.service

import it.com.ibm.generali.capitalreporting.dao.ScopeDao
import it.com.ibm.generali.capitalreporting.model.Scope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ScopeService
{
    @Autowired
    lateinit var scopes: ScopeDao

    fun getScopeParents(scope: Scope): LinkedList<Scope>
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

    fun getChildren(scope: Scope): List<Scope>?
    {
        return this.scopes.findByParent(scope.id)
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
            this.scopes.findByLevel(0)
        }
        tempSiblings.forEach { s -> siblings.add(s) }
        return siblings
    }
}