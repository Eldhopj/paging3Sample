package com.mobiotics.templateapp_photoapp.api.service

import com.mobiotics.templateapp_photoapp.model.photoModel.PhotoResp
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): PhotoResp
}
