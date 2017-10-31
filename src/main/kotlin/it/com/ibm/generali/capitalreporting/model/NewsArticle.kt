package it.com.ibm.generali.capitalreporting.model

import java.util.*
import javax.persistence.*

@Entity
open class NewsArticle
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    var title: String = ""
    var body: String = ""
    var linkUrl: String = ""
    var linkTitle: String = ""
    var published: Boolean = true

    val created = Date()

}