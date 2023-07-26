package com.example.matcha42.configurations

import com.example.matcha42.appuser.AppUserService
import com.example.matcha42.repository.AppUserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.core.userdetails.UserDetailsService

//@Configuration
//class AppConfig {
//
//    @Bean
//    fun userDetailsService(jdbcTemplate: JdbcTemplate): UserDetailsService {
//        return AppUserService()
//    }
//}