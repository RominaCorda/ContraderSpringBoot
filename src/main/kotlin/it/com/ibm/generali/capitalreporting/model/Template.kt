package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import javax.persistence.*

@Entity
open class Template : Serializable
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    @Column(unique = true)
    var name: String = ""

    lateinit var simulationId: String
    lateinit var nodeId: String

    @OneToMany(mappedBy = "template", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report>? = null

    @ManyToMany(mappedBy = "templates")
    var scopes: MutableSet<Scope> = mutableSetOf()
}