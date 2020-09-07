package com.alejandrazuleta.pruebaseleccion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostAdapter(postsList: ArrayList<PostsItem>): RecyclerView.Adapter<PostAdapter.MoviesViewHolder>() {

    private var postsList = ArrayList<PostsItem>()

    init {
        this.postsList = postsList
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var post: PostsItem? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setPost(post: PostsItem) {
            this.post = post
            itemView.tv_user_name.text = post.userId.toString()
            itemView.tv_tittle.text = post.title
            itemView.tv_body.text = post.body
        }

        override fun onClick(v: View) {
            /*
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("post", post)
            intent.putExtra("envia","list")
            itemView.context.startActivity(intent)
             */
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val post = postsList[position]
        holder.setPost(post)
    }

    override fun getItemCount(): Int = postsList.size

}