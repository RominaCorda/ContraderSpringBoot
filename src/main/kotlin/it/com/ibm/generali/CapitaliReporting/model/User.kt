package it.com.ibm.generali.CapitaliReporting.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class User(@Id val username: String, var password: String) : Serializable
{
    // Secondary constructor
    constructor() : this("", "")

    override fun toString(): String = this.username

}