package com.example.homework1_android4.data.repositories

import com.example.homework1_android4.data.apisevices.AnimeApiService
import javax.inject.Inject
import androidx.lifecycle.liveData
import com.example.homework1_android4.utils.Resource
import retrofit2.Response

class AnimeRepository @Inject constructor(private val service: AnimeApiService) {

    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchAnime()))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }

    fun fetchIdAnime(id: Int) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchIdAnime(id)))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }

}