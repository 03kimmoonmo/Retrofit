package com.example.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface api {
    @POST("auth/login/")
    fun login(@Body loginInfo: LoginInfo):Call<LoginResponse>
}