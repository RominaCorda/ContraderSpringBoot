package it.com.ibm.generali.capitalreporting.framework

import it.com.ibm.generali.capitalreporting.dao.UserDao
import it.com.ibm.generali.capitalreporting.model.CapitalUser
import it.com.ibm.generali.capitalreporting.model.ScopeType

object Utilities
{
    fun getScopeType(scopeType: String): ScopeType =
            if (scopeType.toLowerCase() == "official")
                ScopeType.OFFICIAL
            else
                ScopeType.ANALYSIS

    fun getAllUsersExceptAdmin(users: UserDao): List<CapitalUser> =
            users.findAll().filter { it.username != "admin" }

    fun getFirstNonAdminUser(users: UserDao): CapitalUser =
            this.getAllUsersExceptAdmin(users).first()

}