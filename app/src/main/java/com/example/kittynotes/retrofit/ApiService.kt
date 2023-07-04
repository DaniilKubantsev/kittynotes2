package com.example.kittynotes.retrofit

import com.example.kittynotes.Domain.dto.AuthRequest
import com.example.kittynotes.Domain.dto.JwtResponse
import retrofit2.HttpException

object ApiService {
    val api = ServiceBuilder().getApi()

    suspend fun authorisation(authRequest: AuthRequest): JwtResponse? {
        return api.auth(authRequest)
    }

    suspend fun registration(registrationRequest: AuthRequest){
        try{
            return api.registration(registrationRequest)
        }
        catch (e: HttpException){
            if (e.code() == 400) {
                throw RequestExeption("BAD REQUEST")
            }
            if (e.code() == 401) {
                throw RequestExeption("Пользователь уже зарегистрирован")
            }
        }
    }
}

class RequestExeption(message: String): Exception()