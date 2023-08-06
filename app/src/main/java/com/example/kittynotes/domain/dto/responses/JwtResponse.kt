package com.example.kittynotes.domain.dto.responses

data class JwtResponse(
    var type: String?,
    val accessToken: String?,
    val refreshToken: String?
): Response(type)