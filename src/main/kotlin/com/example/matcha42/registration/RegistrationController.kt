package com.example.matcha42.registration
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class RegistrationController(private val registrationService: RegistrationService) {

    @GetMapping("/registration")
    fun showRegistrationForm(model: Model): String {
        model.addAttribute("registrationRequest", RegistrationRequest("", "", ""))
        return "registration"
    }

    @PostMapping("/registration")
    fun register(@ModelAttribute registrationRequest: RegistrationRequest): String {
        registrationService.register(registrationRequest)
        return "redirect:/hello"
    }
}
