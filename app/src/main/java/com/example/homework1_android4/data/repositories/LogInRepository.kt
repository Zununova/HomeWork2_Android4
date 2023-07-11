package com.example.homework1_android4.data.repositories

import com.example.homework1_android4.base.BaseRepository
import com.example.homework1_android4.data.models.login.LogDataModel
import com.example.homework1_android4.data.remote.apisevices.TokenApiService
import javax.inject.Inject

class LogInRepository @Inject constructor(private val service: TokenApiService) : BaseRepository() {
    val request = LogDataModel(
        grant_type = "password",
        client_id = "dd031b32d2f56c990b1425efe6c42ad847e7fe3ab46bf1299f05ecd856bdb7dd",
        username = "Umbrella",
        password = "ghost123"
    )

    fun fetchToken() = doRequest {
        service.fetchToken(request)
    }
}