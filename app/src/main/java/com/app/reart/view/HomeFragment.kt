package com.app.reart.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.app.reart.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: ViewGroup = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup

        val viewPagerMain = v.findViewById<ViewPager2>(R.id.viewpager)
        val artList = arrayListOf<BeAf>(BeAf(R.drawable.before1, R.drawable.after1), BeAf(R.drawable.before2, R.drawable.after2),
            BeAf(R.drawable.before3, R.drawable.after3),BeAf(R.drawable.before4, R.drawable.after4))
        viewPagerMain.adapter = ViewPagerAdapter(artList)
        viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return v
    }

}

class BeAf(val before: Int, val after: Int)