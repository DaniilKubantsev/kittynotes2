package com.example.kittynotes.domain.dto.requests

data class AuthorisationRequest(
    var type: String?,
    var emailOrLogin: String?,
    var password: String?
)