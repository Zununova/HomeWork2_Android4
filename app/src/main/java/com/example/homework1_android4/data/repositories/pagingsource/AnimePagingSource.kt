package com.example.homework1_android4.data.repositories.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework1_android4.data.models.anime.AnimeModel
import com.example.homework1_android4.data.remote.apisevices.AnimeApiService
import retrofit2.HttpException
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class AnimePagingSource (private var service: AnimeApiService) : PagingSource<
        Int, AnimeModel>() {

    override fun getRefreshKey(state: PagingState<Int, AnimeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        val pageSize = params.loadSize
        return try {
            val response = service.fetchAnime(pageSize, position)
            val next = response.links.next
            val nextPageNumber = Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}