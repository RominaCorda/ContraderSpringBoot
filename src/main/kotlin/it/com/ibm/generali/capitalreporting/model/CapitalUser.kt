package it.com.ibm.generali.capitalreporting.model

import java.io.Serializable
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import javax.persistence.*

@Entity
open class CapitalUser() : Serializable
{
    @Id
    lateinit var username: String

    var password: String = ""
        set(value)
        {
            field = this.getSha256(value)
        }

    lateinit var fullName: String
    lateinit var email: String

    @ManyToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.MERGE))
    @JoinTable(name = "CapitalUser_Roles",
            joinColumns = arrayOf(JoinColumn(name = "capitaluser_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
    var roles: MutableSet<Role> = mutableSetOf()

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report>? = null

    @OneToMany(mappedBy = "owner", cascade = arrayOf(CascadeType.ALL))
    var scopeOwn: MutableSet<Scope>? = null

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var simulations: MutableSet<Simulation>? = null

    @ManyToMany(mappedBy = "users")
    var scopes: MutableSet<Scope> = mutableSetOf()

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = arrayOf(CascadeType.MERGE))
    @JoinTable(name = "CapitalUser_Tags",
            joinColumns = arrayOf(JoinColumn(name = "capitaluser_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "usertag_id")))
    var usertags: MutableSet<UserTag> = mutableSetOf()

    var active: Boolean = true

    constructor(username: String, password: String, fullName: String, email: String, role: Role) : this()
    {
        this.username = username
        this.password = password
        this.fullName = fullName
        this.email = email
        this.active = true
        this.roles.add(role)
    }

    private constructor(username: String, password: String, fullName: String, email: String, roles: MutableSet<Role>, usertags: MutableSet<UserTag>) : this()
    {
        this.username = username
        this.password = password
        this.fullName = fullName
        this.email = email
        this.active = true
        this.roles = roles
        this.usertags = usertags
    }

    fun rolesString(): String
    {
        val sb = StringBuilder()
        for (r in this.roles)
        {
            sb.append(r.description)
            sb.append(", ")
        }
        val roles = sb.toString()
        return if (roles.length > 2)
            roles.substring(0, roles.length - 2)
        else ""
    }

    fun tagsString(): String
    {
        val sb = StringBuilder()
        for (t in this.usertags)
        {
            sb.append(t.name)
            sb.append(", ")
        }
        val tagsString = sb.toString()
        return if (tagsString.length > 2)
            tagsString.substring(0, tagsString.length - 2)
        else ""

    }

    fun copy() = CapitalUser(this.username, this.password, this.fullName, this.email, this.roles, this.usertags)

    fun toDetailedString(): String = "$fullName ($username)"

    fun checkPassword(passwordInClear: String): Boolean
    {
        val pwdHash = this.getSha256(passwordInClear)
        return (pwdHash == this.password)
    }

    private fun getSha256(value: String): String
    {
        val digest = MessageDigest.getInstance("SHA-256")
        val encodedhash = digest.digest(value.toByteArray(StandardCharsets.UTF_8))
        return this.bytesToHex(encodedhash)
    }

    private fun bytesToHex(hash: ByteArray): String
    {
        val hexString = StringBuffer()
        for (i in hash.indices)
        {
            val hex = Integer.toHexString(0xff and hash[i].toInt())
            if (hex.length == 1) hexString.append('0')
            hexString.append(hex)
        }
        return hexString.toString()
    }

    override fun toString(): String = username

    companion object Factory
    {
        fun copy(capitalUser: CapitalUser): CapitalUser
        {
            val newUser = CapitalUser()
            newUser.username = capitalUser.username
            newUser.password = capitalUser.password
            newUser.fullName = capitalUser.fullName
            newUser.email = capitalUser.email
            newUser.roles = capitalUser.roles
            newUser.usertags = capitalUser.usertags
            return newUser
        }
    }

}