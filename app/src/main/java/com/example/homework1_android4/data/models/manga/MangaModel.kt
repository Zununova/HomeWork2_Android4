package com.example.homework1_android4.data.models.manga

import com.example.homework1_android4.data.models.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class MangaModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributes: Attributes
)
