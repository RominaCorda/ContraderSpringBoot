package it.com.ibm.generali.CapitalReporting.dao

import it.com.ibm.generali.CapitalReporting.model.User
import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<User, String>

