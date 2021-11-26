package com.app.reart.view.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivitySignUpBinding
import com.app.reart.view.MainActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            Handler().postDelayed({
                val intent = Intent(this, NickActivity::class.java)
                Toast.makeText(this, "닉네임을 입력하세요", Toast.LENGTH_SHORT).show()
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }, 1000)
        }
    }
}