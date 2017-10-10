package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
open class Report : Serializable
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    var template: String = ""
    var reportingPeriod: String = ""
    var simulationId: Int = 0
    val created = Date()

    @ManyToOne
    @JoinColumn(name = "capital_user_id")
    lateinit var user: CapitalUser

    @ManyToOne
    @JoinColumn(name = "scope_id")
    lateinit var scope: Scope

}