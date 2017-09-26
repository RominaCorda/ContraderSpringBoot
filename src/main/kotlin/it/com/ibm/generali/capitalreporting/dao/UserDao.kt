package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.User
import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<User, String>

