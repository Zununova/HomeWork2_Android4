package com.example.homework1_android4.data.models.login

import com.google.gson.annotations.SerializedName

data class TokenModel(

    @SerializedName("access_token")
    val access_token : String,
    @SerializedName("created_at")
    val created_at: Int,
    @SerializedName("expires_in")
    val expires_in: Int,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("token_type")
    val token_type: String
)
