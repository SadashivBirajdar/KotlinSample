package com.example.embitel.kotlinsample.api

import com.example.embitel.kotlinsample.model.Photo
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by emb-sadabir on 19/1/18.
 */
class PhotoRetriever {

    private val service:PhotoApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PhotoApi::class.java)
    }

    fun getPhotos(callback: Callback<Photo>){
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}