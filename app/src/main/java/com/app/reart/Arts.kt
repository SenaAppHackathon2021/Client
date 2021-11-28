package com.app.reart

import java.io.Serializable

class Arts(
    val post_id: Int,
    val title: String,
    val artist: String,
    val created_time: String,
    val picture: Int
) :Serializable

data class ArtworkList(
    val message: String,
    val status_code: String,

    var data: List<Arts>
) : Serializable