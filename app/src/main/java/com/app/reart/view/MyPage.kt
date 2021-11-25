package com.app.reart.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.app.reart.MVC.AuthInterceptor
import com.app.reart.R
import com.app.reart.MVC.RetrofitService
import com.app.reart.MVC.User
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

        setTextMypage()

        userName = v.findViewById(R.id.txt_nick_name)
        userEmail = v.findViewById(R.id.txt_email)
        btnLogout = v.findViewById(R.id.layout_logout)

        btnLogout.setOnClickListener {
            logout()
        }

        return v
    }

    fun setTextMypage() {

        val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()

        val retrofit: Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://27.96.135.11:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        service.getUser().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    userName.text = response.body()?.data?.name
                    userEmail.text = response.body()?.data?.email
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }

        })

    }

    fun logout() {

        var dialog = context?.let { AlertDialog.Builder(it) }
        dialog?.setTitle("로그아웃")
        dialog?.setMessage("정말로 로그아웃 하시겠습니까??")

        fun toast_p() {
            activity?.let{
                Toast.makeText(context, "로그아웃하셨습니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        var dialog_listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE ->
                        toast_p()
                }
            }
        }
        dialog?.setPositiveButton("예", dialog_listener)
        dialog?.setNegativeButton("아니요", null)
        dialog?.show()
    }
}