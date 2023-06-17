package com.example.homework1_android4.data.remote.apisevices

import com.example.homework1_android4.data.models.AnimeResponse
import com.example.homework1_android4.data.models.anime.AnimeModel
import com.example.homework1_android4.data.models.anime.DataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<AnimeModel>

    @GET("anime/{id}")
    suspend fun fetchIdAnime(
        @Path("id") id: Int
    ): DataModel
}