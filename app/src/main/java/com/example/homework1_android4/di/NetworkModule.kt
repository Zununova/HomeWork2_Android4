package com.example.homework1_android4.di

import com.example.homework1_android4.data.remote.LogInRetrofitClient
import com.example.homework1_android4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideLogInRetrofitClient() = LogInRetrofitClient()

    @Singleton
    @Provides
    fun provideTokenApiService(retrofitClient: LogInRetrofitClient) =
        retrofitClient.provideTokenApiService()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        RetrofitClient().provideMangaApiService()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        RetrofitClient().provideAnimeApiService()

}