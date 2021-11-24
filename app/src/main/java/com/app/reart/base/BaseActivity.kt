package com.app.reart.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.reart.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}