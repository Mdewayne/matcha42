package com.example.matcha42.appuser

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class AppUser(
    val name: String,
    val email: String,
    private val password: String,
    val id: Long = 0,
    val locked: Boolean = false,
    val enabled: Boolean = true
) : UserDetails {

    companion object {
        const val USER_ROLE: String = "USER"
    }

    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return listOf(
            SimpleGrantedAuthority(USER_ROLE))
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true // TODO
    }

    override fun isAccountNonLocked(): Boolean {
        return !this.locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true // TODO
    }


    override fun isEnabled(): Boolean {
        return enabled
    }
}