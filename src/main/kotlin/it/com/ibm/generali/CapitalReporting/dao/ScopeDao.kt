package it.com.ibm.generali.CapitalReporting.dao

import it.com.ibm.generali.CapitalReporting.model.Scope
import org.springframework.data.repository.CrudRepository

interface ScopeDao : CrudRepository<Scope, Long>
{
    fun findByParent(parent: Long): List<Scope>
    fun findByLevel(level: Int): List<Scope>
}