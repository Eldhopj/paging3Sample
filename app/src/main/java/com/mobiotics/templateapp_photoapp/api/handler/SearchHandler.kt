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

        private val startingPage = 1


        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
            val position = params.key ?: startingPage // Get the current page

            return try {
                val response = searchService.searchPhotos(query, position, params.loadSize)
                val photos: List<Photo> = response.photos ?: emptyList()

                LoadResult.Page(
                    data = photos,
                    prevKey = if (position == startingPage) null else position - 1,
                    nextKey = if (photos.isEmpty()) null else position + 1
                )
            } catch (exception: IOException) {
                LoadResult.Error(exception)
            } catch (exception: HttpException) {
                LoadResult.Error(exception)
            }
        }

        /**
         *  Define how refreshes resume from the middle of the loaded paged data
         *
         * https://developer.android.com/topic/libraries/architecture/paging/v3-migration#refresh-keys
         *
         */
        override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
            return state.anchorPosition
        }
    }

}
