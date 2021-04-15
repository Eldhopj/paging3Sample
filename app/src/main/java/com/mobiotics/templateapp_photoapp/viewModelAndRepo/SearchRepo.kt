package com.mobiotics.templateapp_photoapp.viewModelAndRepo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mobiotics.templateapp_photoapp.api.handler.SearchHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepo @Inject constructor(private val searchHandler: SearchHandler) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20, // no of item fetching per api call
                maxSize = 100, // maximum number of items in recyclerview, ie, if more item ( more than 100) comes the top items will remove and when we scroll up it will fetch
                enablePlaceholders = false
            ),
            pagingSourceFactory = { searchHandler.PagedSearchedPhotos(query) }
        ).liveData
}
