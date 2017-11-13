package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.CapitalUser
import it.com.ibm.generali.capitalreporting.model.UserTag
import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<CapitalUser, String>
{
    fun findByActiveTrue(): List<CapitalUser>?
    fun findByUsernameLike(username: String): List<CapitalUser>?
    fun findByUsertagsIn(usertags: List<UserTag>): List<CapitalUser>?
    fun findByUsernameLikeAndUsertagsIn(username: String, usertags: List<UserTag>): List<CapitalUser>?
}

