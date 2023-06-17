package com.example.homework1_android4.data.models

import com.google.gson.annotations.SerializedName

data class Links(

    @SerializedName("first")
    val first: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("last")
    val last: String,
)
