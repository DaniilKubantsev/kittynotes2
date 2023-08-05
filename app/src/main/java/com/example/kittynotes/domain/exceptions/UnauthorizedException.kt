package com.example.kittynotes.domain.exceptions

class UnauthorizedException(override val message: String? = "Пользователь уже зарегистрирован"): Exception()