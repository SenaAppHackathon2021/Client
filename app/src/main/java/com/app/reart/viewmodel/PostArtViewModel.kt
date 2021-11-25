package com.app.reart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostArtViewModel: ViewModel() {
    val supporterList = ArrayList<String>(arrayListOf())

    fun addSupporter(supporter: String) {
        supporterList.add(supporter)
    }

    fun removeSupporter() {
        supporterList.clear()
    }
}