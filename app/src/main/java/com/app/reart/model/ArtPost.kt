package com.app.reart.model


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("sponsor")
    val sponsor: String
)