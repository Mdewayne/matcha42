package com.example.matcha42.repository

import com.example.matcha42.appuser.AppUser
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Repository

@Repository
class AppUserRepository(private val jdbcTemplate: JdbcTemplate) {

    private var USER_NOT_FOUND: String = "user with email %s not found"
    fun doDatabaseOperation() { //change
        val query = "SELECT * FROM appUsers"
        val results = jdbcTemplate.queryForList(query)
        results.forEach { row ->
            row.forEach { (columnName, value) ->
                println("$columnName: $value")
            }
        }
    }

    fun findByEmail(email: String) : UserDetails {
        val query = "SELECT * FROM appUsers WHERE email = ?"
        val results = jdbcTemplate.queryForList(query, email)
        if(results.isEmpty())
            throw UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
        val userRow = results[0]
        return AppUser(
            userRow["id"] as Long,
            userRow["name"] as String,
            email,
            userRow["password"] as String,
            userRow["locked"] as Boolean,
            userRow["enabled"] as Boolean
        )

    }
//    fun save(user: AppUser) {
//        val sql = "INSERT INTO appUsers (username, email) VALUES (?, ?)"
//        jdbcTemplate.update(sql, user.username, user.email)
//    }
//
//    fun findAll(): List<AppUser> {
//        val sql = "SELECT * FROM appUsers"
//        return jdbcTemplate.query(sql) { rs, _ ->
//            AppUser(
//                id = rs.getLong("id"),
//                userName = rs.getString("username"),
//                email = rs.getString("email")
//                // Map other columns to User properties as needed
//            )
//        }
//    }
}