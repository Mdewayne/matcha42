package com.example.matcha42.service

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class MyService(private val jdbcTemplate: JdbcTemplate) {
    fun doDatabaseOperation() {
        val query = "SELECT * FROM person"
        val results = jdbcTemplate.queryForList(query)
        results.forEach { row ->
            row.forEach { (columnName, value) ->
                println("$columnName: $value")
            }
        }
    }
}