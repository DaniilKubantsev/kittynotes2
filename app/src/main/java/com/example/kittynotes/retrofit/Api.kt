package com.example.kittynotes.retrofit

import com.example.kittynotes.Domain.dto.AuthRequest
import com.example.kittynotes.Domain.dto.JwtResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/v1/auth")
    suspend fun auth(@Body authRequest: AuthRequest): JwtResponse


    @POST("api/v1/auth/registration")
    suspend fun registration(@Body registrationRequest: AuthRequest)
}