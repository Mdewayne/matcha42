package com.example.matcha42.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MyController {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @GetMapping("/main")
    fun main(): String {
        return "main"
    }
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
//    @GetMapping("/registration")
//    fun registration(): String {
//        return "registration"
//    }
}