package com.example.kittynotes.domain.retrofit

import com.example.kittynotes.domain.dto.requests.AuthorisationRequest
import com.example.kittynotes.domain.dto.requests.RegistrationRequest
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.google.gson.JsonObject
import okhttp3.Request
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/v1/auth/login")
    suspend fun authorisation(@Body authRequest: AuthorisationRequest): Response


    @POST("api/v1/auth/registration")
    suspend fun registration(@Body registrationRequest: RegistrationRequest)
}