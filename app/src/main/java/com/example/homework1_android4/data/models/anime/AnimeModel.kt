package com.example.homework1_android4.data.models.anime

import com.example.homework1_android4.data.models.anime.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class AnimeModel(

    @SerializedName("id")
    val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
)