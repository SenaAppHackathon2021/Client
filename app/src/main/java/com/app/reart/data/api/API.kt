package com.app.reart.data.api

import com.app.reart.data.register.EmailModel
import com.app.reart.data.register.LoginModel
import com.app.reart.data.register.RegisterModel
import com.app.reart.utils.Constants
import com.app.reart.utils.Constants.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface API {

    @POST("register")
    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    //post로 서버에 데이터를 보내는 메서드
    fun postRegister(
        @Body jsonParams: RegisterModel
    ): Call<RegisterPostModel>



    @POST("email")
    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    fun postEmail(
        @Body jsonParams: EmailModel
    ): Call<EmailPostModel>



    @POST("email/check")
    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    fun postEmailCheck(
        @Body jsonParams: EmailModel
    ): Call<EmailPostModel>


    @POST("login")
    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    fun postLogin(
        @Body jsonParams: LoginModel
    ): Call<LoginPostModel>



    companion object {
        fun create(): API {
            val gson: Gson = GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(API::class.java)
        }
    }
}