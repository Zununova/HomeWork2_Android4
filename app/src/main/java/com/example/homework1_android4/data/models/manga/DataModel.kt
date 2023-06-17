package com.example.homework1_android4.data.models.manga

import com.google.gson.annotations.SerializedName

data class DataModel(

    @SerializedName("data")
    val animeModel: MangaModel
)
