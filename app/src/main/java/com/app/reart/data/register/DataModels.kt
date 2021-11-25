package com.app.reart.data.register

import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("password")
    val password: String = ""
)
// email, email check
data class EmailModel(
    @SerializedName("email")
    val email: String = ""
)

data class LoginModel(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("password")
    val password: String = ""
)

