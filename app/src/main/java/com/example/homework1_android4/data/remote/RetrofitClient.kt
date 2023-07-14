package com.example.homework1_android4.data.remote

import com.example.homework1_android4.data.remote.apisevices.AnimeApiService
import com.example.homework1_android4.data.remote.apisevices.MangaApiService
import com.example.homework1_android4.data.remote.apisevices.TokenApiService
import com.example.homework1_android4.data.remote.intersepter.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun loggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }

    fun provideMangaApiService(): MangaApiService {
        return retrofitClient.create(MangaApiService::class.java)
    }

    fun provideTokenApiService(): TokenApiService {
        return retrofitClient.create(TokenApiService::class.java)
    }


}