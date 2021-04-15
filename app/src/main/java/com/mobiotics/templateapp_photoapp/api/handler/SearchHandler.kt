package com.mobiotics.templateapp_photoapp.api.handler

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobiotics.templateapp_photoapp.api.service.SearchService
import com.mobiotics.templateapp_photoapp.model.photoModel.Photo
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.HttpException
import retrofit2.Retrofit


@Singleton
class SearchHandler @Inject constructor(private val retrofit: Retrofit) {

    private val searchService: SearchService by lazy {
        retrofit.create(SearchService::class.java)
    }

    inner class PagedSearchedPhotos(
        private val query: String
    ) : PagingSource<Int, Photo>() {

        private val STARTING_PAGE_INDEX = 1


        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
            val position = params.key ?: STARTING_PAGE_INDEX // Get the current page

            return try {
                val response = searchService.searchPhotos(query, position, params.loadSize)
                val photos: List<Photo> = response.photos ?: emptyList()

                LoadResult.Page(
                    data = photos,
                    prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                    nextKey = if (photos.isEmpty()) null else position + 1
                )
            } catch (exception: IOException) {
                LoadResult.Error(exception)
            } catch (exception: HttpException) {
                LoadResult.Error(exception)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
            TODO("Not yet implemented")
        }
    }

}
