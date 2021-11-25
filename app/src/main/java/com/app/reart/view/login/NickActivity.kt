package com.app.reart.view.activity

import android.os.Bundle
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.databinding.ActivityNickBinding

class NickActivity : BaseActivity<ActivityNickBinding>(R.layout.activity_nick) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick)
    }
}