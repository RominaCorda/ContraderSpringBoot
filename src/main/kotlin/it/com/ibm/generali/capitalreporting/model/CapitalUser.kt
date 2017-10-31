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

    @ManyToOne
    @JoinColumn(name = "role_id")
    lateinit var role: Role

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var reports: MutableSet<Report>? = null

    @OneToMany(mappedBy = "owner", cascade = arrayOf(CascadeType.ALL))
    var scopeOwn: MutableSet<Scope>? = null

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var simulations: MutableSet<Simulation>? = null

    /**
     * TODO: Rename to scopeViews
     */
    @ManyToMany(mappedBy = "users")
    var scopes: MutableSet<Scope> = mutableSetOf()

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
            newUser.role = capitalUser.role
            return newUser
        }
    }

}