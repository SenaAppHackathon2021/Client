package com.app.reart.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.app.reart.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
//            val intent = Intent(this, ::class.java) 넘어갈 화면 넣어주기
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }, DURATION)
    }

    companion object {
        private const val DURATION: Long = 1500
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}