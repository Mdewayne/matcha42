package com.example.matcha42.registration

import com.example.matcha42.appuser.AppUserService
import org.springframework.stereotype.Service

@Service
class RegistrationService(val appUserService: AppUserService) {
    fun register(registrationRequest: RegistrationRequest): String {
        appUserService.createUser(
            registrationRequest.name,
            registrationRequest.email,
            registrationRequest.password
        ) // TODO
        return "redirect:/hello"
    }

}