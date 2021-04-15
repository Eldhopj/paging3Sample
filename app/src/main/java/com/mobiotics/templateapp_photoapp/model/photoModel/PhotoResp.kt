package com.mobiotics.templateapp_photoapp.model.photoModel


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class PhotoResp(
    @SerializedName("total")
    val total: Int? = null, // 133
    @SerializedName("total_pages")
    val totalPages: Int? = null, // 7
    @SerializedName("results")
    val photos: List<Photo>? = null
) : Parcelable
