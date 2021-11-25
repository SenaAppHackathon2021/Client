package com.app.reart.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.reart.R
import com.app.reart.RetrofitService
import com.app.reart.User
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MyPage : Fragment() {

    lateinit var userName: TextView
    lateinit var userEmail: TextView
    lateinit var btnLogout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater.inflate(R.layout.fragment_my_page, container, false)

//        setTextMypage()

        userName = v.findViewById(R.id.txt_nick_name)
        userEmail = v.findViewById(R.id.txt_email)

        return v
    }

//    fun setTextMypage() {
//
//        val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
//
//        val retrofit: Retrofit = Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("http://192.168.0.21:8040/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(RetrofitService::class.java)
//
//        service.getUser().enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if(response.isSuccessful){
//                    userName.text = response.body()?.data?.name
//                    userEmail.text = response.body()?.data?.email
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//
//            }
//
//        })
//
//    }
}