package com.example.homework1_android4.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.homework1_android4.base.BaseRepository
import com.example.homework1_android4.data.remote.apisevices.AnimeApiService
import com.example.homework1_android4.data.repositories.pagingsource.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 20
        )
    ) {
        AnimePagingSource(service)
    }.liveData


    fun fetchIdAnime(id: Int) = doRequest {
        service.fetchIdAnime(id)
    }
}