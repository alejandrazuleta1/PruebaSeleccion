package com.alejandrazuleta.pruebaseleccion.view

import android.content.Intent
import android.graphics.Color
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
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.post_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostAdapter(postsList: ArrayList<PostEntity>,onClickListener: OnClickListener): RecyclerView.Adapter<PostAdapter.PostsViewHolder>() {

    private var postsList = ArrayList<PostEntity>()
    private var onClickListener : OnClickListener? = null

    init {
        this.postsList = postsList
        this.onClickListener=onClickListener
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {

        private var post: PostEntity? = null

        fun setPost(post: PostEntity) {
            this.post = post
            itemView.tv_user_name.text=post.username
            itemView.tv_tittle.text = post.title
            itemView.tv_body.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = postsList[position]
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                onClickListener!!.onItemClick(PostEntity(
                    post.id,
                    post.body,
                    post.title,
                    post.userId,
                    post.user_Name,
                    post.username,
                    post.email,
                    post.addressCity,
                    post.phone,
                    post.companyName,
                    post.rating,
                    true,
                    post.fav
                ))
                val intent = Intent(p0!!.context, DetalleActivity::class.java)
                intent.putExtra("post", post)
                p0.context.startActivity(intent)
            }
        })
        if(post.read)holder.itemView.cardView.setCardBackgroundColor(Color.parseColor("#F5F5F5"))
        else holder.itemView.cardView.setCardBackgroundColor(Color.parseColor("#BBDEFB"))
        holder.setPost(post)
    }

    override fun getItemCount(): Int = postsList.size

    fun removeItem(viewHolder: RecyclerView.ViewHolder) {
        postsList.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }

    fun removeAllItem() {
        postsList.clear()
        notifyDataSetChanged()
    }
}