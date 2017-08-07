package it.com.ibm.generali.CapitaliReporting.dao

import it.com.ibm.generali.CapitaliReporting.model.User
import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<User, String>

