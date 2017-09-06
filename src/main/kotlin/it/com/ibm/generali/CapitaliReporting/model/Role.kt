package it.com.ibm.generali.CapitaliReporting.model

import java.io.Serializable
import javax.persistence.*


@Entity
open class Role : Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L
    var description: String = ""

    @OneToMany(mappedBy = "role", cascade = arrayOf(CascadeType.ALL))
    var users: MutableSet<User>? = null

}

