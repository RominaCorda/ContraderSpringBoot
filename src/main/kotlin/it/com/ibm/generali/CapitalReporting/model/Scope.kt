package it.com.ibm.generali.CapitalReporting.model

import java.io.Serializable
import javax.persistence.*

@Entity
open class Scope : Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    lateinit var name: String
    var published: Boolean = false

    @OneToMany
    var template: MutableSet<Template>? = null

}