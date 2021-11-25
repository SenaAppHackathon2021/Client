package com.app.reart.view.fragments.artboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.reart.R
import com.app.reart.model.BoardItem

class ArtBoardViewModel : ViewModel() {
    val postResponse: MutableLiveData<List<BoardItem>> = MutableLiveData()

    fun getPosts() {
        // TODO : Inject Repository into ViewModel and get actual Data

        postResponse.value = getDummyData()
    }

    fun getDummyData(): List<BoardItem> = listOf(
        BoardItem(
            R.drawable.after1,
            "유리병으로 만든 선인장들",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.after2,
            "쓰레기로 만든 아인슈타인",
            "양태웅",
            "2021년 11월 11일 12시 30분"
        ),
        BoardItem(
            R.drawable.after3,
            "페타이어를 굴리는 쇠똥구리",
            "유재석",
            "2021년 11월 12일 15시 07분"
        ),
        BoardItem(
            R.drawable.after4,
            "귀여운 강아지들",
            "박상선",
            "2021년 11월 21일 17시 53분"
        ),
        BoardItem(
            R.drawable.after1,
            "유리병으로 만든 선인장들",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.after2,
            "쓰레기로 만든 아인슈타인",
            "양태웅",
            "2021년 11월 11일 12시 30분"
        ),
        BoardItem(
            R.drawable.after3,
            "페타이어를 굴리는 쇠똥구리",
            "유재석",
            "2021년 11월 12일 15시 07분"
        ),
        BoardItem(
            R.drawable.after4,
            "귀여운 강아지들",
            "박상선",
            "2021년 11월 21일 17시 53분"
        ),
        BoardItem(
            R.drawable.after1,
            "유리병으로 만든 선인장들",
            "홍길동",
            "2021년 11월 06일 16시 21분"
        ),
        BoardItem(
            R.drawable.after2,
            "쓰레기로 만든 아인슈타인",
            "양태웅",
            "2021년 11월 11일 12시 30분"
        ),
        BoardItem(
            R.drawable.after3,
            "페타이어를 굴리는 쇠똥구리",
            "유재석",
            "2021년 11월 12일 15시 07분"
        ),
        BoardItem(
            R.drawable.after4,
            "귀여운 강아지들",
            "박상선",
            "2021년 11월 21일 17시 53분"
        ),
    )
}