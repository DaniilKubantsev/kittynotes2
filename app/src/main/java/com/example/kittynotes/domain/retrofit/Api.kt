package com.example.kittynotes.domain.retrofit

import com.example.kittynotes.domain.dto.AuthRequest
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.example.kittynotes.domain.dto.responses.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/v1/auth/login")
    suspend fun authorisation(@Body authRequest: AuthRequest): retrofit2.Response<JwtResponse>


    @POST("api/v1/auth/registration")
    suspend fun registration(@Body registrationRequest: AuthRequest)
}