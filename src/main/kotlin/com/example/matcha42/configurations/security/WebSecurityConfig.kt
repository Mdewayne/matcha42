package com.example.matcha42.configurations.security

import com.example.matcha42.appuser.AppUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val appUserService: AppUserService) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers("/registration", "/").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin { form ->
                form
                    .loginPage("/login")
                    .permitAll()
            }
            .logout { logout -> logout.permitAll() }
        return http.build()
    }

    @Bean
    fun authManager(userService: AppUserService) : AuthenticationManager {
        return ProviderManager(daoAuthenticationProvider())
    }

    @Bean
    fun daoAuthenticationProvider() : DaoAuthenticationProvider {
        val daoProvider = DaoAuthenticationProvider()
        daoProvider.setUserDetailsService(appUserService)
        daoProvider.setPasswordEncoder(appUserService.passwordEncoder)
        return daoProvider
    }

}