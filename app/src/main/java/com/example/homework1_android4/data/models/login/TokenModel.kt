package com.example.homework1_android4.data.models.login

import com.google.gson.annotations.SerializedName

data class TokenModel(

    @SerializedName("access_token")
    val access_token: String,

    @SerializedName("refresh_token")
    val refresh_token: String
)
