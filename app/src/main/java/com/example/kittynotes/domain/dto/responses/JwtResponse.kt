package com.example.kittynotes.domain.dto.responses

data class JwtResponse(
    val accessToken: String?,
    val refreshToken: String?
): Response {
    private val type = "Bearer"
}