package com.rana.muncakapp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiClient {

    @FormUrlEncoded
    @POST("cek_login.php")
    fun login(
        @Field("username") username : String,
        @Field("password") password : String
    ): Call<ResponseLogin>

}