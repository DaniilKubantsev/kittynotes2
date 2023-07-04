package com.example.kittynotes.utils

import java.net.PasswordAuthentication
import java.util.regex.Pattern

object Validator {
    private val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValidEmail(email: String): Boolean{
        if(!EMAIL_ADDRESS_PATTERN.matcher(email).matches()) throw InvalidUserData("Invalid email addres!")

        return true
    }

    fun isValidUsername(username: String): Boolean{
        if(EMAIL_ADDRESS_PATTERN.matcher(username).matches()) throw InvalidUserData("Invalid user name!")

        return true
    }

    fun isValidPassword(password: String, repeatedPassword: String): Boolean{
        if(!(password == repeatedPassword)) throw InvalidUserData("Passwords don't match!")
        if(password.length < 8) throw InvalidUserData("Password is too short!")

        return true
    }
}

//class PasswordMismatchExeption(message: String): Exception()
//class PasswordLengthExeption(message: String): Exception()
//class InvalidEmailExeption(message: String): Exception()
//class InvalidUsernameExeption(message: String): Exception()

class InvalidUserData(message: String): Exception()