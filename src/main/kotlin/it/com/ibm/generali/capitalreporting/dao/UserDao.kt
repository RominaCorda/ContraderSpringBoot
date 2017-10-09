package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.CapitalUser
import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<CapitalUser, String>

