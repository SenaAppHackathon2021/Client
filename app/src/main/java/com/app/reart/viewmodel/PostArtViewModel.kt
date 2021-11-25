package com.app.reart.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.app.reart.model.ArtPost
import com.app.reart.model.Picture
import com.google.gson.Gson

class PostArtViewModel: ViewModel() {
    var photoBeforeUri: Uri? = null
    var photoBeforeBase64: String = ""
    var photoAfterUri: Uri? = null
    var photoAfterBase64: String = ""
    val supporterList = ArrayList<String>(arrayListOf())

    fun addSupporter(supporter: String) {
        supporterList.add(supporter)
    }

    fun removeSupporter() {
        supporterList.clear()
    }

    fun uploadPost(artPost: ArtPost) {
        val post = Gson().toJson(artPost)

        Log.d("uploadPost", "onCreateView: $post")
    }
}