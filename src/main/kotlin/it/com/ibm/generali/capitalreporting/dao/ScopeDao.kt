package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Scope
import it.com.ibm.generali.capitalreporting.model.ScopeType
import org.springframework.data.repository.CrudRepository

interface ScopeDao : CrudRepository<Scope, Long>
{
    fun findByType(type: ScopeType): List<Scope>
    fun findByParent(parent: Long): List<Scope>
    fun findByTypeAndParent(type: ScopeType, parent: Long): List<Scope>
    fun findByParentAndPublishedIsTrue(parent: Long): List<Scope>
    fun findByTypeAndParentAndPublishedIsTrue(type: ScopeType, parent: Long): List<Scope>
}