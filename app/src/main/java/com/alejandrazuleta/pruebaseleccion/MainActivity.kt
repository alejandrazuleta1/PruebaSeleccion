package com.alejandrazuleta.pruebaseleccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.ApiService
import com.alejandrazuleta.pruebaseleccion.Model.Posts
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listPosts = ArrayList<PostsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        loadListPost()
    }

    private fun loadListPost() {
        ApiService.create()
            .getPosts()
            .enqueue(object : Callback<Posts> {
                override fun onFailure(call: Call<Posts>, t: Throwable) {
                    Log.d("Error",t?.message)
                }

                override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                    if (response.isSuccessful) {
                        listPosts = response.body()!! as ArrayList<PostsItem>
                        val postAdapter = PostAdapter(listPosts)
                        recyclerView.adapter = postAdapter
                    }
                }
            })
    }
}