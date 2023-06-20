package com.example.homework1_android4.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.homework1_android4.base.BaseRepository
import com.example.homework1_android4.data.remote.apisevices.MangaApiService
import com.example.homework1_android4.data.repositories.pagingsource.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 20
        )
    ) {
        MangaPagingSource(service)
    }.liveData


    fun fetchMangaById(id: Int) = doRequest {
        service.fetchMangaById(id)
    }
}