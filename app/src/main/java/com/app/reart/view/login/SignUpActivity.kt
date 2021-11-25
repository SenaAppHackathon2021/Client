package com.app.reart.view.activity

import android.os.Bundle
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}