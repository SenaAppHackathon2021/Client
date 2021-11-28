package com.app.reart

import retrofit2.Call
import retrofit2.http.*

interface ArtsRetrofitService {
    @GET("arts")
    fun getArtsList(): Call<ArtworkList?>

}