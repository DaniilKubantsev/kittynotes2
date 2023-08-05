package com.example.kittynotes.domain.useCase

import com.example.kittynotes.domain.dto.AuthRequest
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.example.kittynotes.domain.exceptions.BadRequestException
import com.example.kittynotes.domain.retrofit.ApiService
import com.example.kittynotes.domain.utils.Validator

class UsernameSingInUseCase {
    suspend fun execute(
        username: String,
        password: String,
    ): JwtResponse?{
        if(
            Validator.isValidUsername(username = username) &&
            Validator.isValidPassword(password = password)
        ){
            //формирование запроса
            val authorisationRequest = AuthRequest("", username, password)
            val result = ApiService.authorisation(authorisationRequest)
            return result
        }
        else{
            throw BadRequestException()
        }
    }
}