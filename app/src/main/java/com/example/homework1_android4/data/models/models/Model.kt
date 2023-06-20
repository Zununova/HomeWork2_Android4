package com.example.homework1_android4.data.models.models

import com.example.homework1_android4.data.models.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class Model(

    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributes: Attributes
)