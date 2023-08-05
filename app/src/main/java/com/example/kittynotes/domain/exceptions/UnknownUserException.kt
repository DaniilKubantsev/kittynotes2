package com.example.kittynotes.domain.exceptions

class UnknownUserException(override val message: String? = "Пользователь не найден"): Exception()
