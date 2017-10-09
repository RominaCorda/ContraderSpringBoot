package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.UserTag
import org.springframework.data.repository.CrudRepository

interface UserTagDao : CrudRepository<UserTag, Long>