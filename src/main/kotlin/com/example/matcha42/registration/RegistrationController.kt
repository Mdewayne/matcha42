package com.example.matcha42.registration

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/registration")
class RegistrationController (private var registrationService: RegistrationService ){

    @PostMapping
    fun register(@RequestBody registrationRequest: RegistrationRequest) :String {
        return registrationService.register(registrationRequest)
    }
}