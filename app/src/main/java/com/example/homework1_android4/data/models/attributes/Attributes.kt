package com.example.homework1_android4.data.models.attributes

import com.example.homework1_android4.data.models.attributes.image.Image
import com.example.homework1_android4.data.models.attributes.title.Title
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("synopsis")
    val detail: String,
    @SerializedName("titles")
    val title: Title,
    @SerializedName("posterImage")
    val image: Image

)
