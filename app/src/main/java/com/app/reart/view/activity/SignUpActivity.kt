package com.app.reart.view.activity

import android.os.Bundle
import android.util.Log
import com.app.reart.R
import com.app.reart.base.BaseActivity
import com.app.reart.data.api.API
import com.app.reart.data.api.EmailPostModel
import com.app.reart.data.register.EmailModel
import com.app.reart.data.register.RegisterModel
import com.app.reart.databinding.ActivityNickBinding
import com.app.reart.databinding.ActivitySignUpBinding
import com.app.reart.utils.Extensions.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){

    private val api = API.create()
    private val _binding by lazy { ActivityNickBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sessionSend()
    }

    private fun sessionSend() {
        binding.btnSendEmailAuth.setOnClickListener{
            val data = EmailModel(binding.editSignUpEmail.text.toString())
            api.postEmail(data).enqueue(object: Callback<EmailPostModel>{
                override fun onResponse(
                    call: Call<EmailPostModel>,
                    response: Response<EmailPostModel>
                ) {
                    Log.d(LoginActivity.TAG,response.toString())

                    if(response.isSuccessful){
                        toast("인증 번호가 전송되었습니다")
                    }
                }

                override fun onFailure(call: Call<EmailPostModel>, t: Throwable) {
                    Log.e(TAG, "{${t.message.toString()}}")

                }

            })
        }
    }
    companion object{
        const val TAG = "SignUpActivity"
    }
}
