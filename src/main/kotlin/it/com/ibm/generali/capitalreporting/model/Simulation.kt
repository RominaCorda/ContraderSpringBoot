package it.com.ibm.generali.capitalreporting.model

import java.util.*
import javax.persistence.*

@Entity
open class Simulation
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    @Column(unique = true)
    var name: String = ""

    var official: Boolean = false
    lateinit var reportingPeriod: String
    val created = Date()

    @ManyToOne
    @JoinColumn(name = "capital_user_id")
    lateinit var user: CapitalUser


}