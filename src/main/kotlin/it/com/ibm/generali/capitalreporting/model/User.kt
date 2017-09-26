package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import javax.persistence.*

@Entity
open class User() : Serializable
{
    @Id
    lateinit var username: String
    lateinit var password: String
    lateinit var fullName: String
    lateinit var email: String

    @ManyToOne
    @JoinColumn(name = "role_id")
    lateinit var role: Role

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report>? = null

    var active: Boolean = true

    constructor(username: String, password: String, fullName: String, email: String, role: Role) : this()
    {
        this.username = username
        this.password = password
        this.fullName = fullName
        this.email = email
        this.active = true
        this.role = role
    }

    fun toDetailedString(): String = "$fullName ($username)"

    override fun toString(): String = username

    companion object Factory
    {
        fun copy(user: User): User
        {
            val newUser = User()
            newUser.username = user.username
            newUser.password = user.password
            newUser.fullName = user.fullName
            newUser.email = user.email
            newUser.role = user.role
            return newUser
        }
    }

}