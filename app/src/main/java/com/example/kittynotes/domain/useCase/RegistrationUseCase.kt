package com.example.kittynotes.domain.useCase


import android.widget.Toast
import com.example.kittynotes.domain.dto.AuthRequest
import com.example.kittynotes.domain.exceptions.BadRequestException
import com.example.kittynotes.domain.exceptions.UnauthorizedException
import com.example.kittynotes.domain.retrofit.ApiService


import com.example.kittynotes.domain.utils.Validator
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

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
            val registrationRequest = AuthRequest(email, username, password)
            ApiService.registration(registrationRequest)
        }
        else{
            throw BadRequestException()
        }
    }
}
