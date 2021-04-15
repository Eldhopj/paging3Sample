package com.mobiotics.templateapp_photoapp.model.photoModel


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Photo(
    @SerializedName("id")
    val id: String? = null, // eOLpJytrbsQ
    @SerializedName("created_at")
    val createdAt: String? = null, // 2014-11-18T14:35:36-05:00
    @SerializedName("width")
    val width: Int? = null, // 4000
    @SerializedName("height")
    val height: Int? = null, // 3000
    @SerializedName("color")
    val color: String? = null, // #A7A2A1
    @SerializedName("blur_hash")
    val blurHash: String? = null, // LaLXMa9Fx[D%~q%MtQM|kDRjtRIU
    @SerializedName("likes")
    val likes: Int? = null, // 286
    @SerializedName("liked_by_user")
    val likedByUser: Boolean? = null, // false
    @SerializedName("description")
    val description: String? = null, // A man drinking a coffee.
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("urls")
    val urls: Urls? = null,
    @SerializedName("links")
    val links: Links? = null
) : Parcelable
