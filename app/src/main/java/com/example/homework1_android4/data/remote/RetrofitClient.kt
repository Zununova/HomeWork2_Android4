package com.example.homework1_android4.data.remote

import com.example.homework1_android4.data.apisevices.AnimeApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }
}