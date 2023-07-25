package com.example.matcha42.registration

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/registration")
class RegistrationController (private var registrationService: RegistrationService ){
    fun register(@RequestBody registrationRequest: RegistrationRequest) :String {
        return registrationService.register(registrationRequest)
    }
}