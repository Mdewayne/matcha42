package com.example.matcha42.appuser

import com.example.matcha42.repository.AppUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AppUserService (private val appUserRepository: AppUserRepository) : UserDetailsService {

    val passwordEncoder = BCryptPasswordEncoder()
    fun createUser(username: String, email: String, password: String): AppUser {
        val newUser = AppUser(username, email, passwordEncoder.encode(password))
        appUserRepository.save(newUser)
        return AppUser(username, email, password,
            appUserRepository.getAppUserIdByEmail(email))

    }

//    fun getAllUsers(): List<AppUser> {
//        return appUserRepository.findAll()
//    }
    override fun loadUserByUsername(email: String): UserDetails {
        return appUserRepository.findByEmail(email)
    }
}