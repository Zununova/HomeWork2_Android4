package com.example.homework1_android4.data.remote.apisevices

import com.example.homework1_android4.data.models.login.LogDataModel
import com.example.homework1_android4.data.models.login.TokenModel
import com.example.homework1_android4.data.models.login.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface TokenApiService {

    @POST("oauth/token")
    suspend fun fetchToken(
        @Body request: LogDataModel
    ): TokenResponse
}