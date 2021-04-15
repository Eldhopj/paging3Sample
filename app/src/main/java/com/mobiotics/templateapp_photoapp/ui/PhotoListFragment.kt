package com.mobiotics.templateapp_photoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobiotics.templateapp_photoapp.adapter.LoaderStateAdapter
import com.mobiotics.templateapp_photoapp.adapter.PhotoPagingAdapter
import com.mobiotics.templateapp_photoapp.databinding.FragmentListPhotoBinding
import com.mobiotics.templateapp_photoapp.viewModelAndRepo.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : PhotoBaseFragment<FragmentListPhotoBinding>() {

    private val searchViewModel by viewModels<SearchViewModel>()

    private val recyclerPagingAdapter: PhotoPagingAdapter by lazy { PhotoPagingAdapter() }

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListPhotoBinding = FragmentListPhotoBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        initRecyclerView()
        recyclerViewClicks()
        clicks()
    }

    private fun initRecyclerView() {
        binding?.recyclerView?.run {
            adapter =
                recyclerPagingAdapter.withLoadStateHeaderAndFooter( // This will show the retry dialog in bottom and top
                    header = LoaderStateAdapter { recyclerPagingAdapter.retry() },
                    footer = LoaderStateAdapter { recyclerPagingAdapter.retry() }
                )
        }
    }

    private fun observeData() {
        searchViewModel.photos("cats").observe(viewLifecycleOwner) {
            recyclerPagingAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private fun clicks() {
        binding?.run {
            buttonRetry.setOnClickListener { recyclerPagingAdapter.retry() }
        }

    }

    private fun recyclerViewClicks() {
        recyclerPagingAdapter.setOnContentClickListener {

        }
    }
}
