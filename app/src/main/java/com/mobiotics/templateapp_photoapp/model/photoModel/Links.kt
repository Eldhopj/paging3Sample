package com.mobiotics.templateapp_photoapp.model.photoModel


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Links(
    @SerializedName("self")
    val self: String? = null, // https://api.unsplash.com/users/ugmonk
    @SerializedName("html")
    val html: String? = null, // http://unsplash.com/@ugmonk
    @SerializedName("photos")
    val photos: String? = null, // https://api.unsplash.com/users/ugmonk/photos
    @SerializedName("likes")
    val likes: String? = null, // https://api.unsplash.com/users/ugmonk/likes
    @SerializedName("download")
    val download: String? = null // http://unsplash.com/photos/eOLpJytrbsQ/download
)
