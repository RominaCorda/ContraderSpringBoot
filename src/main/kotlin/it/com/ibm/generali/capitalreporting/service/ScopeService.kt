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
}