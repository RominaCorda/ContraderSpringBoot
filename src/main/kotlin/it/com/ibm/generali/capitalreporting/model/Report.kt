package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
open class Report : Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L
        private set

    var template: String = ""
    var reportingPeriod: String = ""
    var simulationId: Int = 0
    val created = Date()

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @ManyToOne
    @JoinColumn(name = "scope_id")
    lateinit var scope: Scope

}