package com.example.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("non_field_errors")
    var nonFieldErrors: Array<String>?
)