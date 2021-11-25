package com.app.reart.model


import com.google.gson.annotations.SerializedName

data class ArtPost(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("sponsor")
    val sponsor: List<String>
)