package com.app.reart.view.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivityLoginBinding
import com.app.reart.view.MainActivity
import com.app.reart.view.SplashActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Reart)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener{

            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }, 1000)

        }
        binding.textSignUp.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
            finish()
        }
    }
}