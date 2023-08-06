package com.example.kittynotes.domain.dto.responses

class MessageResponse(private val type: String?, private val message: String?): Response(type)