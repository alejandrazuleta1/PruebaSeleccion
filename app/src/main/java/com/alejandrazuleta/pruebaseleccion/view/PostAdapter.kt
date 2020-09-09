package com.alejandrazuleta.pruebaseleccion.view

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.*
import com.alejandrazuleta.pruebaseleccion.R
import kotlinx.android.synthetic.main.post_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostAdapter(postsList: ArrayList<PostsItem>): RecyclerView.Adapter<PostAdapter.PostsViewHolder>() {

    private var postsList = ArrayList<PostsItem>()

    init {
        this.postsList = postsList
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var post: PostsItem? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setPost(post: PostsItem) {
            var userName = ""
            this.post = post
            ApiService.create()
                .getUserById(post.userId)
                .enqueue(object : Callback<UsersItem> {
                    override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                        val usersItem =response.body() as UsersItem
                        itemView.tv_user_name.text=usersItem.username
                        userName=usersItem.username
                    }
                    override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                        Log.d("ErrorAdapter",t.message!!)
                    }

                })
            itemView.tv_tittle.text = post.title
            itemView.tv_body.text = post.body
        }


        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetalleActivity::class.java)
            intent.putExtra("post", post)
            intent.putExtra("envia","list")
            itemView.setBackgroundColor(Color.TRANSPARENT)
            itemView.context.startActivity(intent)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)

        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = postsList[position]
        if(position<2) holder.itemView.setBackgroundColor(Color.BLUE)
        holder.setPost(post)
    }

    override fun getItemCount(): Int = postsList.size

    fun removeItem(viewHolder: RecyclerView.ViewHolder) {
        postsList.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }

}