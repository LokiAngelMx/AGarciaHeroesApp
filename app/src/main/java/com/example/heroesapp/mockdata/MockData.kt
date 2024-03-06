package com.example.heroesapp.mockdata

import com.example.heroesapp.models.User

class MockData {
    companion object {
        val users = listOf<User>(
            User(email = "loki@gmail.com", password = "12345"),
            User(email = "pepe@gmail.com", password = "12345"),
            User(email = "dani@gmail.com", password = "12345"),
        )

        fun getUsers() {
            println("Get users")
        }
    }
}