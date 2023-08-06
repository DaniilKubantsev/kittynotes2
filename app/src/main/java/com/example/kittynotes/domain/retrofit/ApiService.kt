package com.example.kittynotes.domain.retrofit


import com.example.kittynotes.domain.dto.requests.AuthorisationRequest
import com.example.kittynotes.domain.dto.requests.RegistrationRequest
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.example.kittynotes.domain.dto.responses.MessageResponse
import com.example.kittynotes.domain.exceptions.BadRequestException
import com.example.kittynotes.domain.exceptions.ResponseException
import com.example.kittynotes.domain.exceptions.UnauthorizedException
import com.google.gson.Gson
import retrofit2.HttpException

object ApiService {
    private val api = ServiceBuilder().getApi()

//    suspend fun authorisation(authorisationRequest: AuthorisationRequest): JwtResponse? {
//
////        val response = api.authorisation(authorisationRequest).body
////        return if(response.isSuccessful){
////            response.body()
////        }else{
////            val gson = Gson()
////            val messageResponse = gson.fromJson<MessageResponse>(response.body())
////            throw ResponseException()
////        }

//    }

    suspend fun registration(registrationRequest: RegistrationRequest){
        try{
            return api.registration(registrationRequest)
        }
        catch (e: HttpException){
            if (e.code() == 400) {
                throw BadRequestException()
            }
            if (e.code() == 401) {
                throw UnauthorizedException()
            }
        }
    }
}


