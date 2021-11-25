package com.app.reart.MVC

class User(
    val data: userData? = null,
    val massage: String? = null,
    val status: Int? = 0

)
data class userData(
    val name: String? = null,
    val email: String? = null
)