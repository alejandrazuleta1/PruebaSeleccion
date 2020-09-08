package com.alejandrazuleta.pruebaseleccion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import kotlinx.android.synthetic.main.post_list_item.view.*
import java.util.ArrayList

class PostsFavoritesAdapter(postsFavoritesList: ArrayList<PostEntity>) :
RecyclerView.Adapter<PostsFavoritesAdapter.PostViewHolder>(){
    private var postsFavoritesList = ArrayList<PostEntity>()

    init {
        this.postsFavoritesList=postsFavoritesList
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var post: PostEntity? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setPost(post: PostEntity) {
            this.post = post
            itemView.tv_tittle.text = post.title
            itemView.tv_body.text = post.body
            itemView.im_fav.setImageResource(R.drawable.baseline_favorite_black_24dp)
            itemView.im_fav.setOnClickListener {
                val repository = Repository()
                repository.deletePostFavorite(post.id)
            }
        }


        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetalleActivity::class.java)
            intent.putExtra("post", post)
            intent.putExtra("envia","favorites")
            itemView.context.startActivity(intent)
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView =
            LayoutInflater.from(p0.context).inflate(R.layout.post_list_item, p0, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        val post = postsFavoritesList[p1]
        p0.setPost(post)
    }

    override fun getItemCount(): Int = postsFavoritesList.size

}