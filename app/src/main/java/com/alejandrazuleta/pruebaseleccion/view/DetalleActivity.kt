package com.alejandrazuleta.pruebaseleccion.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.alejandrazuleta.pruebaseleccion.Model.*
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.R
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.post_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleActivity : AppCompatActivity() {

    private lateinit var postsItem : PostsItem
    private lateinit var postFavorite : PostEntity
    private var envia = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        envia = intent?.getStringExtra("envia").toString()

        if(envia=="favorites"){
            postFavorite = intent?.getSerializableExtra("post") as PostEntity
            updateFavoriteUI(postFavorite)
        }else{
            postsItem = intent?.getSerializableExtra("post") as PostsItem
            updateUI(postsItem)
        }

        im_fav.setOnClickListener {
            if(envia=="favorites"){
                //update

            }else{
                //insert
                ApiService.create()
                    .getUserById(postsItem.userId)
                    .enqueue(object : Callback<UsersItem> {
                        override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                            val usersItem =response.body() as UsersItem

                            val repository = Repository()
                            repository.insertPostFavorite(
                                postsItem.id,
                                postsItem.body,
                                postsItem.title,
                                postsItem.userId,
                                usersItem.username,
                                0F
                            )

                        }
                        override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                            Log.d("ErrorAdapter",t.message!!)
                        }

                    })
            }
        }

        ratingBar.setOnRatingBarChangeListener(
            object : RatingBar.OnRatingBarChangeListener{
                override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                    val repository = Repository()
                    repository.update(
                        PostEntity(
                            postFavorite.id,
                            postFavorite.body,
                            postFavorite.title,
                            postFavorite.userId,
                            postFavorite.userName,
                            p1
                    ))
                }
            }

        )


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateUI(postsItem: PostsItem) {
        im_fav.setImageResource(R.drawable.baseline_favorite_border_black_24dp)
        ApiService.create()
            .getUserById(postsItem.userId)
            .enqueue(object : Callback<UsersItem> {
                override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                    val usersItem =response.body() as UsersItem
                    tv_username.text=usersItem.username
                    tv_nombre.text=usersItem.name
                    tv_email.text=usersItem.email
                    tv_ciudad.text=usersItem.address.city
                    tv_telefono.text=usersItem.phone
                    tv_companyname.text=usersItem.company.name
                }
                override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                    Log.d("ErrorDetalleUsuario",t?.message)
                }

            })
        tv_postTittle.text=postsItem.title
        tv_postBody.text=postsItem.body

    }

    private fun updateFavoriteUI(postFavorite: PostEntity) {
        im_fav.setImageResource(R.drawable.baseline_favorite_black_24dp)
        ratingBar.visibility= View.VISIBLE
        ratingBar.rating=postFavorite.rating

        ApiService.create()
            .getUserById(postFavorite.userId)
            .enqueue(object : Callback<UsersItem> {
                override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                    val usersItem =response.body() as UsersItem
                    tv_username.text=usersItem.username
                    tv_nombre.text=usersItem.name
                    tv_email.text=usersItem.email
                    tv_ciudad.text=usersItem.address.city
                    tv_telefono.text=usersItem.phone
                    tv_companyname.text=usersItem.company.name
                }
                override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                    Log.d("ErrorDetalleUsuario",t?.message)
                }

            })
        tv_postTittle.text=postFavorite.title
        tv_postBody.text=postFavorite.body

    }
}
