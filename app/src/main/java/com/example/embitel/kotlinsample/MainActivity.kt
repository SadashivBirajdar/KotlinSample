package com.example.embitel.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.embitel.kotlinsample.api.PhotoRetriever
import com.example.embitel.kotlinsample.model.Hit
import com.example.embitel.kotlinsample.model.Photo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnPhotoClick{

    private val tag: String? = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        var retriever = PhotoRetriever()
        val callback = object : Callback<Photo> {

            override fun onFailure(call: Call<Photo>?, t: Throwable?) {
                Log.e(tag, "Problem with server", t)
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<Photo>?, response: Response<Photo>?) {
                response?.isSuccessful.let {
                    val hits = response?.body()?.hits!!
                    var mainAdapter = MainAdapter(hits, this@MainActivity)
                    recyclerView.adapter = mainAdapter
                    progressBar.visibility = View.GONE
                }
            }
        }
        retriever.getPhotos(callback)
    }

    override fun onClick(photo: Hit) {
        Log.d(tag, photo.tags)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
