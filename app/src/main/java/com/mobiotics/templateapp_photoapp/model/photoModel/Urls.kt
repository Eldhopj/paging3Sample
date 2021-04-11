package com.mobiotics.templateapp_photoapp.model.photoModel


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Urls(
    @SerializedName("raw")
    val raw: String? = null, // https://images.unsplash.com/photo-1416339306562-f3d12fefd36f
    @SerializedName("full")
    val full: String? = null, // https://hd.unsplash.com/photo-1416339306562-f3d12fefd36f
    @SerializedName("regular")
    val regular: String? = null, // https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=92f3e02f63678acc8416d044e189f515
    @SerializedName("small")
    val small: String? = null, // https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=263af33585f9d32af39d165b000845eb
    @SerializedName("thumb")
    val thumb: String? = null // https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=8aae34cf35df31a592f0bef16e6342ef
)
