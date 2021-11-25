package com.app.reart.view.fragments.materialboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.reart.R
import com.app.reart.model.BoardItem

class MaterialBoardViewModel : ViewModel() {
    val postResponse: MutableLiveData<List<BoardItem>> = MutableLiveData()

    fun getPosts() {
        // TODO : Inject Repository into ViewModel and get actual Data

        postResponse.value = getDummyData()
    }

    fun getDummyData(): List<BoardItem> = listOf(
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.before2,
            "단추 구해요",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        )
    )
}