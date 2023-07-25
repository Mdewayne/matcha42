package com.example.matcha42.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }
}