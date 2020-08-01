package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.80.161.202:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(api::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.let {
            "strimg"
        }
        btn_login.setOnClickListener {
            val id = edit_id.text.toString()
            val password = edit_password.text.toString()
            val email = edit_email.text.toString()
            val loginInfo = LoginInfo(id, password, email)
            api.login(loginInfo).enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("Login", t.message.toString())
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful)
                        txt_response.text =
                            response.body()?.nonFieldErrors?.get(0) ?: "Empty Response"
                    else
                        txt_response.text = response.errorBody()?.string()
                }

            })
        }
    }

}
