package it.com.ibm.generali.CapitalReporting.dao

import it.com.ibm.generali.CapitalReporting.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleDao : CrudRepository<Role, Long>