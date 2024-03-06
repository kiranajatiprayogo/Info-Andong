package com.rana.muncakapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://infoandongviasawit.000webhostapp.com/api_android/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getInstance(): ApiClient {
        return getRetrofitClient().create(ApiClient::class.java)
    }
}