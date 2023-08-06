package com.example.kittynotes.domain.useCase


import com.example.kittynotes.domain.dto.requests.RegistrationRequest
import com.example.kittynotes.domain.exceptions.BadRequestException
import com.example.kittynotes.domain.retrofit.ApiService


import com.example.kittynotes.domain.utils.Validator

class RegistrationUseCase {
    suspend fun execute(
        email: String,
        username: String,
        password: String,
        repeatedPassword: String
    ){
        //проверка данных на валидность
        if(
            Validator.isValidEmail(email = email) &&
            Validator.isValidUsername(username = username) &&
            Validator.isValidPassword(password = password, repeatedPassword = repeatedPassword)
        ){
            //формирование запроса
            val registrationRequest = RegistrationRequest(email, username, password)
            ApiService.registration(registrationRequest)
        }
        else{
            throw BadRequestException()
        }
    }
}
