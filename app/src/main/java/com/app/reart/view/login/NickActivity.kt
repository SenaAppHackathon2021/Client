package com.app.reart.view.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivityNickBinding
import com.app.reart.view.MainActivity

class NickActivity : BaseActivity<ActivityNickBinding>(R.layout.activity_nick) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            Handler().postDelayed({
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }, 1000)
        }
    }
}