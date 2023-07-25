package com.example.matcha42.controllers

import com.example.matcha42.repository.AppUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PrintDB(private val appUserRepository: AppUserRepository) { //delete
    @GetMapping("/data")
    fun getDataFromDatabase() {
        appUserRepository.doDatabaseOperation()
    }
}