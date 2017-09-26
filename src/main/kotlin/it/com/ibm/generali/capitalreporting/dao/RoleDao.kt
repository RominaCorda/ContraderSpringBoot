package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleDao : CrudRepository<Role, Long>
{
    fun findByDescription(role: String): Role
}