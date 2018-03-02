package com.example.embitel.kotlinsample.api

import com.example.embitel.kotlinsample.model.Photo
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by emb-sadabir on 19/1/18.
 */
interface PhotoApi {

    @GET("?key=7730410-2e3ec3c8e4ee9cabc627f707e&q=nature&image_type=photo")
    fun getPhotos(): Call<Photo>
}