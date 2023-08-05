package com.example.kittynotes.domain.utils

object Validator {
    fun isValidEmail(email: String): Boolean{
        return email.length < 254
    }

    fun isValidUsername(username: String): Boolean{
        return username.length < 320
    }

    fun isValidPassword(password: String, repeatedPassword: String): Boolean{
        return password == repeatedPassword && password.length > 8 && password.length < 320
    }

    fun isValidPassword(password: String): Boolean{
        return password.length in 9..319
    }
}

