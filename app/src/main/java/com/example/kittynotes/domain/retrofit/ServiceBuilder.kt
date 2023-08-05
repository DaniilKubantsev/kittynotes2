package com.example.kittynotes.domain.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceBuilder {

    private val interceptor = HttpLoggingInterceptor()

    private val clien = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kaplaan.ru/backend/app/")
        .client(clien)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApi(): Api {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val api = retrofit.create(Api::class.java)
        return api
    }
}