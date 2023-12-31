package com.example.homework1_android4.data.models

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<T>
)