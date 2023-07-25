package com.example.matcha42.appuser

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class AppUser(
    private var id: Long,
    private var name: String,
    private var email: String,
    private var password: String,
    private var locked: Boolean,
    private var enabled: Boolean
) : UserDetails {

    private var role: String = "USER"

    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return listOf(
            SimpleGrantedAuthority(role))
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