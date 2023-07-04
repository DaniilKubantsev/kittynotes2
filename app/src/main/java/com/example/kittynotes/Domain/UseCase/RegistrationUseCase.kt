package com.example.kittynotes.Domain.UseCase

import com.example.kittynotes.Domain.dto.AuthRequest
import com.example.kittynotes.retrofit.ApiService
import com.example.kittynotes.retrofit.RequestExeption
import com.example.kittynotes.utils.InvalidUserData
import com.example.kittynotes.utils.Validator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegistrationUseCase {

    fun execute(
        email: String,
        username: String,
        password: String,
        repeatedPassword: String,

    ){
        try{
            if(Validator.isValidEmail(email = email)
                && Validator.isValidUsername(username = username)
                && Validator.isValidPassword(password = password, repeatedPassword = repeatedPassword)
            ){
                val registrationRequest = AuthRequest(
                    email,
                    username,
                    password
                )

                val job = CoroutineScope(Dispatchers.IO).async {
                        ApiService.registration(registrationRequest)
                }

            }
        }
        catch (e: InvalidUserData){
            throw InvalidUserData(e.message.toString())
        }
        catch (e: RequestExeption){
            throw RequestExeption(e.message.toString())
        }
    }
}