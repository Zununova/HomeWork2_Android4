package com.example.homework1_android4.data.remote.apisevices

import com.example.homework1_android4.data.models.Response
import com.example.homework1_android4.data.models.models.Model
import com.example.homework1_android4.data.models.models.DataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int
    ): Response<Model>

    @GET("edge/anime/{id}")
    suspend fun fetchIdAnime(
        @Path("id") id: Int
    ): DataModel
}