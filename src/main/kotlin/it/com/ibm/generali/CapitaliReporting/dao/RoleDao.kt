package it.com.ibm.generali.CapitaliReporting.dao

import it.com.ibm.generali.CapitaliReporting.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleDao : CrudRepository<Role, Long>