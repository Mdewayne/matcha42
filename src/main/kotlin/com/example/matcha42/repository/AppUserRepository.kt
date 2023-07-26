package com.example.matcha42.repository

import com.example.matcha42.appuser.AppUser
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Repository

@Repository
class AppUserRepository(private val jdbcTemplate: JdbcTemplate) {
    companion object {
        const val USER_NOT_FOUND: String = "user with email %s not found"
    }

    fun findByEmail(email: String) : AppUser {
        val query = "SELECT * FROM appUsers WHERE email = ?"
        val results = jdbcTemplate.queryForList(query, email)
        if(results.isEmpty())
            throw UsernameNotFoundException(
                String.format(USER_NOT_FOUND, email))
        val userRow = results[0]
        return AppUser(
            userRow["name"] as String,
            email,
            userRow["password"] as String,
            userRow["id"] as Long,
            userRow["locked"] as Boolean,
            userRow["enabled"] as Boolean
        )

    }
    fun save(appUser: AppUser) {
        val sql = "INSERT INTO appusers (name, email, password, locked, enabled)" +
                " VALUES (?, ?, ?, ?, ?)"
        jdbcTemplate.update(
            sql,
            appUser.name,
            appUser.email,
            appUser.password,
            appUser.locked,
            appUser.enabled)

        jdbcTemplate
    }

    fun getAppUserIdByEmail(email: String): Long {
        val sql = "SELECT id FROM appusers WHERE email = ?"
        return jdbcTemplate.queryForObject(sql, Long::class.java, email)
    }
//
//    fun findAll(): List<AppUser> { //FIXME
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