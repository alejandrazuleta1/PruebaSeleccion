package com.alejandrazuleta.pruebaseleccion

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.*
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.post_list_item.*
import kotlinx.android.synthetic.main.post_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleActivity : AppCompatActivity() {

    private lateinit var postsItem : PostsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        postsItem = intent?.getSerializableExtra("post") as PostsItem
        updateUI(postsItem)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateUI(postsItem: PostsItem) {
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
}
