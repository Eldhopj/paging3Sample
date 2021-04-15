package com.mobiotics.templateapp_photoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobiotics.templateapp_photoapp.databinding.UnsplashPhotoLoadStateFooterBinding


/**
 * This class enables loading / retry in footer or in header
 * */
class LoaderStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoaderStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = UnsplashPhotoLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    inner class LoadStateViewHolder(binding: UnsplashPhotoLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val progressBar = binding.progressBar
        private val buttonRetry = binding.buttonRetry
        private val textViewError = binding.textViewError

        init {
            binding.buttonRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            progressBar.isVisible = loadState is LoadState.Loading
            buttonRetry.isVisible = loadState !is LoadState.Loading
            textViewError.isVisible = loadState !is LoadState.Loading
        }
    }
}
