package com.app.reart.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.data.api.API
import com.app.reart.data.api.LoginPostModel
import com.app.reart.data.register.LoginModel
import com.app.reart.databinding.ActivityLoginBinding
import com.app.reart.utils.Extensions.toast
import com.app.reart.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val api = API.create()

    companion object{
        const val TAG = "LoginActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        login()
        goToSignUp()
    }

    private fun login() {
        binding.btnLogin.setOnClickListener{
            val data = LoginModel(binding.editEmail.text.toString(), binding.editPassword.text.toString())
            api.postLogin(data).enqueue(object : Callback<LoginPostModel>{
                override fun onResponse(
                    call: Call<LoginPostModel>,
                    response: Response<LoginPostModel>
                ) {
                    Log.d(TAG,response.toString())
                    if(response.body().toString().isEmpty()){
                        toast("이메일 또는 비밀번호를 입력하세요")
                    }
                }

                override fun onFailure(call: Call<LoginPostModel>, t: Throwable) {
                    Log.d(TAG,t.message.toString())
                    Log.d(TAG,"실패 : {$t}")

                    toast("로그인에 실패했습니다")
                }

            })
        }
    }

    private fun goToSignUp(){
        binding.textSignUp.setOnClickListener{
            val intent =  Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.none,R.anim.horizon_exit)
            finish()
        }
    }
}