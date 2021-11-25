package com.app.reart.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivityNickBinding
import com.app.reart.utils.Extensions.toast

class NickActivity : BaseActivity<ActivityNickBinding>(R.layout.activity_nick) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        goBack()
    }

    private fun goBack(){
        binding.goBack.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            overridePendingTransition(R.anim.none, R.anim.none)
            finish()
        }
    }
}