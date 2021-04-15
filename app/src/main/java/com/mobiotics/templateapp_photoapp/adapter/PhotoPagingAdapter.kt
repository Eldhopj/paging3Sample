package com.mobiotics.templateapp_photoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mobiotics.templateapp_photoapp.R
import com.mobiotics.templateapp_photoapp.databinding.ItemUnsplashPhotoBinding
import com.mobiotics.templateapp_photoapp.model.photoModel.Photo

class PhotoPagingAdapter :
    PagingDataAdapter<Photo, PhotoPagingAdapter.PhotoViewHolder>(DiffCallback()) {

    private var listener: ((Photo) -> Unit)? = null

    fun setOnContentClickListener(listener: (Photo) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bindData(currentItem)
        }
    }

    inner class PhotoViewHolder(binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private val imageView = binding.imageView
        private val name = binding.textViewUserName
        private var item: Photo? = null

        init {
            itemView.setOnClickListener(this)
        }

        //Binding of data happens in here
        fun bindData(item: Photo) {
            this.item = item
            item.run {
                Glide.with(itemView)
                    .load(urls?.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                name.text = user?.username
            }
        }

        override fun onClick(view: View?) {
            val position = bindingAdapterPosition // Get the index of the view holder
            if (position == RecyclerView.NO_POSITION) { // Makes sure this position is still valid
                return
            }
            item?.let {
                /**
                 * All the clicks will come in here
                 * */
                if (view === itemView) {
                    listener?.invoke(
                        it,
                    ) // we catch the click on the item view then pass it over the interface and then to our activity
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem == newItem

    }
}
