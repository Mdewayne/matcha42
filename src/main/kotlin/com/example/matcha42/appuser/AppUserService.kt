package com.example.matcha42.appuser

import com.example.matcha42.appuser.AppUser
import com.example.matcha42.repository.AppUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

//@Service
//class AppUserService (private val appUserRepository: AppUserRepository) : UserDetailsService {
    //    fun createUser(username: String, email: String): AppUser {
//        val newUser = AppUser(username = username, email = email)
//        appUserRepository.save(newUser)
//        return
//    }
//
//    fun getAllUsers(): List<AppUser> {
//        return appUserRepository.findAll()
//    }
//    override fun loadUserByUsername(email: String): UserDetails {
//        return appUserRepository.findByEmail(email)
//    }
//}