package com.example.homework1_android4.data.models.login

import com.google.gson.annotations.SerializedName

data class LogDataModel(

    @SerializedName("grant_type")
    val grant_type: String,

    @SerializedName("client_id")
    val client_id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
)