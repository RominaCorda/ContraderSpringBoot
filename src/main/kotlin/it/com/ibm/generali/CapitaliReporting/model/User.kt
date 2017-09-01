package it.com.ibm.generali.CapitaliReporting.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class User : Serializable
{
    @Id
    lateinit var username: String

    lateinit var password: String
    lateinit var fullName: String
    lateinit var email: String

    var active: Boolean = true

    override fun toString(): String = this.username

}