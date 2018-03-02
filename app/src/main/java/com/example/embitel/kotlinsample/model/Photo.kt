package com.example.embitel.kotlinsample.model

import java.io.Serializable

/**
 * Created by emb-sadabir on 17/1/18.
 */
data class Photo(
		val totalHits: Int, //500
		val hits: List<Hit>,
		val total: Int //154313
)

data class Hit(
		val previewHeight: Int, //84
		val likes: Int, //85
		val favorites: Int, //71
		val tags: String, //fantasy, nature, beautiful
		val webformatHeight: Int, //360
		val views: Int, //11009
		val webformatWidth: Int, //640
		val previewWidth: Int, //150
		val comments: Int, //18
		val downloads: Int, //6949
		val pageURL: String, //https://pixabay.com/en/fantasy-nature-beautiful-dawn-3077928/
		val previewURL: String, //https://cdn.pixabay.com/photo/2018/01/12/10/19/fantasy-3077928_150.jpg
		val webformatURL: String, //https://pixabay.com/get/ea35b60821f6093ed95c4518b74b4195e373e3d504b0144093f1c970a3ecb2_640.jpg
		val imageWidth: Int, //3840
		val user_id: Int, //2946451
		val user: String, //peter_pyw
		val type: String, //photo
		val id: Int, //3077928
		val userImageURL: String, //https://cdn.pixabay.com/user/2018/01/12/08-06-25-409_250x250.jpg
		val imageHeight: Int //2160
):Serializable