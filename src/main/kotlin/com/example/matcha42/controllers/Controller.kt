package com.example.matcha42.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController {
    @GetMapping("/")
    fun home(): String {
        return "main"
    }
}