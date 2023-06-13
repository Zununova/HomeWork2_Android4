package com.example.homework1_android4.data.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(

    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val animeList: List<T>
)