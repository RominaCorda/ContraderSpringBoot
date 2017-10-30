package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import javax.persistence.*


@Entity
open class Role : Serializable
{
    @Id
    @TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "OUTPUT_DEF", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    var id: Long = 0L
        private set

    @Column(unique = true)
    var description: String = ""

    @OneToMany(mappedBy = "role", cascade = arrayOf(CascadeType.ALL))
    var capitalUsers: MutableSet<CapitalUser> = mutableSetOf()

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = arrayOf(CascadeType.MERGE))
    @JoinTable(name = "Role_Permissions",
            joinColumns = arrayOf(JoinColumn(name = "role_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "permission_id")))
    var permissions: MutableSet<Permission> = mutableSetOf()

}

