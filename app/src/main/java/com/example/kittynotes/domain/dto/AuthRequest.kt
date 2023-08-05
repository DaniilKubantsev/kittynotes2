package com.example.kittynotes.domain.dto

data class AuthRequest(
    val email: String?,
    val login: String?,
    val password: String?
)