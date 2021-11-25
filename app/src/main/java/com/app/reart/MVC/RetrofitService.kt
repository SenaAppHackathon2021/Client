package com.app.reart.MVC

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/profile")
    fun getUser():Call<User>
}