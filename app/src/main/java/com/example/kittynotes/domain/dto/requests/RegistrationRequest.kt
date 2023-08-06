package com.example.kittynotes.domain.dto.requests

data class RegistrationRequest(
    var email: String?,
    var login: String?,
    var password: String?
)