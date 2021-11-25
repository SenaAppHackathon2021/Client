package com.app.reart.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.app.reart.Arts
import com.app.reart.ArtsAdapter
import com.app.reart.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: ViewGroup = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup

        val viewPagerMain = v.findViewById<ViewPager2>(R.id.viewpager)
        val artList = arrayListOf(BeAf(R.drawable.before1, R.drawable.after1), BeAf(R.drawable.before2, R.drawable.after2),
            BeAf(R.drawable.before3, R.drawable.after3),BeAf(R.drawable.before4, R.drawable.after4))
        viewPagerMain.adapter = ViewPagerAdapter(artList)
        viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        var rvHomeArtwork = v.findViewById<RecyclerView>(R.id.rv_home_artwork)
        rvHomeArtwork.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        rvHomeArtwork.setHasFixedSize(true)

        var artWorkList = arrayListOf(Arts(1,"페트병으로 만든 돌고래","Moon", "20:00",R.drawable.after5),
            Arts(1,"깡통강아지","hwaun", "2021년 11월 16일 15시 30분",R.drawable.after4),
            Arts(1,"타이어 쇠똥구리","jjo77", "2021년 11월 16일 15시 30분",R.drawable.after3),
            Arts(1,"단추로 만든 아인슈타인","read", "2021년 11월 16일 15시 30분",R.drawable.after2),
            Arts(1,"페트병 선인장","user123", "2021년 11월 16일 15시 30분",R.drawable.after1),)

        rvHomeArtwork.adapter = ArtsAdapter(artWorkList)
        return v
    }

}

class BeAf(val before: Int, val after: Int)