package com.example.homework1_android4.data.models.login

data class TokenResponse(

    val access_token: String,
    val token_type: String,
    val expires_in: Long
)
