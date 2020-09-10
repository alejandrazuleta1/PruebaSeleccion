package com.alejandrazuleta.pruebaseleccion.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.ApiService
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem
import com.alejandrazuleta.pruebaseleccion.R
import kotlinx.android.synthetic.main.post_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesPostsAdapter(postsFavoritesList:ArrayList<PostEntity>) :
    RecyclerView.Adapter<FavoritesPostsAdapter.PostsViewHolder>() {

    private var postsFavoritesList = ArrayList<PostEntity>()

    init {
        this.postsFavoritesList=postsFavoritesList
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var post: PostEntity? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setPost(post: PostEntity) {
            this.post = post
            itemView.tv_user_name.text = post.username
            itemView.tv_tittle.text = post.title
            itemView.tv_body.text = post.body
        }


        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetalleActivity::class.java)
            intent.putExtra("post", post)
            itemView.context.startActivity(intent)
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostsViewHolder {
        val itemView =
            LayoutInflater.from(p0.context).inflate(R.layout.post_list_item, p0, false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PostsViewHolder, p1: Int) {
        val post = postsFavoritesList[p1]
        p0.setPost(post)
    }

    override fun getItemCount(): Int = postsFavoritesList.size

}