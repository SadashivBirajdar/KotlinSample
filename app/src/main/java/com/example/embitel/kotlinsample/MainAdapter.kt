package com.example.embitel.kotlinsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.embitel.kotlinsample.model.Hit
import kotlinx.android.synthetic.main.photo_item.view.*

/**
 * Created by emb-sadabir on 19/1/18.
 */
class MainAdapter(private var photos: List<Hit>,
                  private var click: OnPhotoClick) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photoDetails = photos[position]
        holder?.bindPhotoData(photoDetails)
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var photoViewHolder: View = itemView

        init {
            itemView.setOnClickListener(this)
            itemView.tag = this
        }

        override fun onClick(v: View) {
            click.onClick(photos[adapterPosition])
        }

        fun bindPhotoData(photoDetails: Hit) {
            photoViewHolder?.txt_tags?.text = "Tag: " + photoDetails.tags
            photoViewHolder?.txt_likes?.text = "Likes: " + photoDetails.likes.toString()
            photoViewHolder?.txt_favourites?.text = "Favourites: " + photoDetails.favorites.toString()
            if (photoDetails.previewURL.isNotEmpty()) {
                Glide.with(photoViewHolder?.txt_tags?.context)
                        .load(photoDetails.previewURL)
                        .into(photoViewHolder?.photo_item)
            }
        }
    }
}