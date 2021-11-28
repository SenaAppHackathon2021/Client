package com.app.reart.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.app.reart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://27.96.135.11:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ArtsRetrofitService::class.java)

        service.getArtsList().enqueue(object : Callback<ArtworkList?> {
            override fun onResponse(call: Call<ArtworkList?>, response: Response<ArtworkList?>) {
                var artWorkList = response.body()?.data
                rvHomeArtwork.adapter = ArtsAdapter(artWorkList as ArrayList<Arts>)
            }

            override fun onFailure(call: Call<ArtworkList?>, t: Throwable) {
                Log.d("로그","Home False")
            }
        })
        return v
    }

}

class BeAf(val before: Int, val after: Int)