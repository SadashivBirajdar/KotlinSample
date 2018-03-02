package com.example.embitel.kotlinsample

import com.example.embitel.kotlinsample.model.Hit

/**
 * Created by emb-sadabir on 19/1/18.
 */
interface OnPhotoClick {
    fun onClick(photo: Hit)
}