package com.example.kittynotes.domain.retrofit


import com.example.kittynotes.domain.dto.AuthRequest
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.example.kittynotes.domain.dto.responses.MessageResponse
import com.example.kittynotes.domain.exceptions.BadRequestException
import com.example.kittynotes.domain.exceptions.ResponseException
import com.example.kittynotes.domain.exceptions.UnauthorizedException
import com.example.kittynotes.domain.exceptions.UnknownUserException
import com.google.gson.Gson
import retrofit2.HttpException
import java.lang.RuntimeException

object ApiService {
    private val api = ServiceBuilder().getApi()

    suspend fun authorisation(authorisationRequest: AuthRequest): JwtResponse? {

//        return try{
//           api.authorisation(authorisationRequest) as JwtResponse
//        }
//        catch(e: HttpException){
//            if (e.code() == 400) {
//                throw BadRequestException("server message")
//            }
//            if (e.code() == 401) {
//                throw UnknownUserException()
//            }
//            throw RuntimeException()
//        }

        val response = api.authorisation(authorisationRequest)
        return if(response.isSuccessful){
            response.body()
        }else{
            val gson = Gson()
            val messageResponse = gson.fromJson<>()
            throw ResponseException()
        }

    }

    suspend fun registration(registrationRequest: AuthRequest){
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


