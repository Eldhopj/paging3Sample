package com.mobiotics.templateapp_photoapp.viewModelAndRepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mobiotics.templateapp_photoapp.model.photoModel.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repo: SearchRepo,
) : ViewModel() {

    fun photos(query: String): LiveData<PagingData<Photo>> = repo.getSearchResults(query)
        .cachedIn(viewModelScope) // caches value in viewModel scope, for preventing crash in orientation change

}
