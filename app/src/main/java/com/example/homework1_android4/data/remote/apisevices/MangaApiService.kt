package com.example.homework1_android4.data.remote.apisevices

import com.example.homework1_android4.data.models.AnimeResponse
import com.example.homework1_android4.data.models.anime.DataModel
import com.example.homework1_android4.data.models.manga.MangaModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<MangaModel>

    @GET("manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): DataModel
}