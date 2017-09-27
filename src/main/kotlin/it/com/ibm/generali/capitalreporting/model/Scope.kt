package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import javax.persistence.*

@Entity
open class Scope : Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L
        private set

    lateinit var name: String
    var published: Boolean = false

    var parent: Long = -1L
    var level: Int = 0

    @OneToMany(mappedBy = "scope", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report> = mutableSetOf()

    fun addReport(report: Report)
    {
        this.reports.add(report)
    }

}