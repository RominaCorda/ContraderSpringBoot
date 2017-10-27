package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Permission
import org.springframework.data.repository.CrudRepository

interface PermissionDao : CrudRepository<Permission, Long>
{
    fun findByDescription(description: String): Permission
}
