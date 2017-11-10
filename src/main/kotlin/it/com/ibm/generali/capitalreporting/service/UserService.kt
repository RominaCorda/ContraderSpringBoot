package it.com.ibm.generali.capitalreporting.service

import it.com.ibm.generali.capitalreporting.dao.UserDao
import it.com.ibm.generali.capitalreporting.model.CapitalUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class UserService
{
    @Autowired
    lateinit var users: UserDao

    fun copyUser(userKey: String, userNameNew:String): CapitalUser
    {
        val user = this.users.findOne(userKey)
        val userCopy = user.copy()
        userCopy.username = userNameNew
        this.users.save(userCopy)
        return userCopy
    }

}