package com.app.reart.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterPostModel( // register
    @Expose
    @SerializedName("id")
    var id: String? = null,
    @Expose
    @SerializedName("password")
    var password: String? = null,
    @Expose
    @SerializedName("email")
    var email: String? = null,
)

data class EmailPostModel( // email , email check 동일
    @Expose
    @SerializedName("email")
    val email: String? = null,
)
data class LoginPostModel( // login
    @Expose
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)

