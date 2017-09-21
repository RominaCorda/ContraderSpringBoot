package it.com.ibm.generali.CapitalReporting.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
open class Template : Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    lateinit var name: String
}