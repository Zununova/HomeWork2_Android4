package com.example.homework1_android4.data.repositories.pagingsource

import android.net.Uri
import androidx.paging.PagingState
import com.example.homework1_android4.base.BasePagingSource
import com.example.homework1_android4.data.models.models.Model
import com.example.homework1_android4.data.remote.apisevices.MangaApiService
import retrofit2.HttpException
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class MangaPagingSource(private var service: MangaApiService) : BasePagingSource<Model>() {

    override fun getRefreshKey(state: PagingState<Int, Model>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Model> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        val pageSize = params.loadSize
        return try {
            val response = service.fetchManga(pageSize, position)
            val nextPageNumber =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
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