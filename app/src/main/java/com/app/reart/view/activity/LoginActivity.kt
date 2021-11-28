package com.app.reart.view.activity

import android.os.Bundle
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}