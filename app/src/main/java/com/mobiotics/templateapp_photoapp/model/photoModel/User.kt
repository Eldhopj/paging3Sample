package com.mobiotics.templateapp_photoapp.model.photoModel


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class User(
    @SerializedName("id")
    val id: String? = null, // Ul0QVz12Goo
    @SerializedName("username")
    val username: String? = null, // ugmonk
    @SerializedName("name")
    val name: String? = null, // Jeff Sheldon
    @SerializedName("first_name")
    val firstName: String? = null, // Jeff
    @SerializedName("last_name")
    val lastName: String? = null, // Sheldon
    @SerializedName("instagram_username")
    val instagramUsername: String? = null, // instantgrammer
    @SerializedName("twitter_username")
    val twitterUsername: String? = null, // ugmonk
    @SerializedName("portfolio_url")
    val portfolioUrl: String? = null, // http://ugmonk.com/
    @SerializedName("profile_image")
    val profileImage: ProfileImage? = null,
    @SerializedName("links")
    val links: Links? = null
) : Parcelable
