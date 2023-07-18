package com.example.matcha42.controllers

import com.example.matcha42.service.MyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PrintDB(private val myService: MyService) {
    @GetMapping("/data")
    fun getDataFromDatabase() {
        myService.doDatabaseOperation()
    }
}