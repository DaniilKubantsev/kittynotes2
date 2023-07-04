package com.example.kittynotes.Domain.dto

data class AuthRequest(
    val email: String?,
    val login: String?,
    val password: String?
)