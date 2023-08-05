package com.example.kittynotes.domain.exceptions

class BadRequestException(override val message: String? = "Проверьте данные для входа"): Exception()
