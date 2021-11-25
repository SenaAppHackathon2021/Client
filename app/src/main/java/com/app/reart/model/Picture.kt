package com.app.reart.model


import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("before")
    val before: String,
    @SerializedName("after")
    val after: String
)