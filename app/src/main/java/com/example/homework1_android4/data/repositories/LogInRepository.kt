package com.example.homework1_android4.data.repositories

import com.example.homework1_android4.base.BaseRepository
import com.example.homework1_android4.data.models.login.LogDataModel
import com.example.homework1_android4.data.remote.apisevices.TokenApiService
import javax.inject.Inject

class LogInRepository @Inject constructor(private val service: TokenApiService) : BaseRepository() {

    fun fetchToken(logDataModel: LogDataModel) = doRequest {
        service.fetchToken(logDataModel)
    }
}