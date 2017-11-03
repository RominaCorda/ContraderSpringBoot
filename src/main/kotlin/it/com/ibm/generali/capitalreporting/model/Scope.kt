package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import javax.persistence.*

@Entity
open class Scope : Serializable
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    lateinit var name: String

    @ManyToOne
    @JoinColumn(name = "capital_user_id")
    lateinit var owner: CapitalUser

    var tags: String = ""
    var published: Boolean = false
    var parent: Long = -1L
    var type: ScopeType = ScopeType.ANALYSIS

    @OneToMany(mappedBy = "scope", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report> = mutableSetOf()

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = arrayOf(CascadeType.MERGE))
    @JoinTable(name = "Scope_Templates",
            joinColumns = arrayOf(JoinColumn(name = "scope_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "template_id")))
    var templates: MutableSet<Template> = mutableSetOf()

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = arrayOf(CascadeType.MERGE))
    @JoinTable(name = "Scope_CapitalUsers",
            joinColumns = arrayOf(JoinColumn(name = "scope_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "capitaluser_id")))
    var users: MutableSet<CapitalUser> = mutableSetOf()

    fun addReport(report: Report)
    {
        this.reports.add(report)
    }

    fun addTemplate(template: Template)
    {
        this.templates.add(template)
    }

    fun setAllTags(tags: List<String>)
    {
        var allTags = ""
        tags.forEach { tag -> allTags += tag + Scope.TAG_DELIMITER }
        this.tags = allTags.substring(0, allTags.length - 1)
    }

    fun getAllTags(): List<String>
    {
        return this.tags.split(Scope.TAG_DELIMITER)
    }

    fun hasNoReports(): Boolean =
            this.reports.size == 0

    override fun toString(): String = this.name

    companion object
    {
        val TAG_DELIMITER = ';'
    }

}