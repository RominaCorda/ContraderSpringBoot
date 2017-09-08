package it.com.ibm.generali.CapitalReporting.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
open class User : Serializable
{
    @Id
    lateinit var username: String
    lateinit var password: String
    lateinit var fullName: String
    lateinit var email: String

    @ManyToOne
    @JoinColumn(name = "role_id")
    lateinit var role: Role

    var active: Boolean = true

    fun toDetailedString(): String = "$fullName ($username)"

    override fun toString(): String = "$username"

    companion object Factory
    {
        fun copy(user: User): User
        {
            val newUser = User()
            newUser.username = user.username
            newUser.password = user.password
            newUser.fullName = user.fullName
            newUser.email = user.email
            newUser.role = user.role
            return newUser
        }
    }

}