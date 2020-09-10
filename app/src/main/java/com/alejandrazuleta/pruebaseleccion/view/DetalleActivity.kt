package com.alejandrazuleta.pruebaseleccion.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.alejandrazuleta.pruebaseleccion.Model.*
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.R
import com.alejandrazuleta.pruebaseleccion.presenter.DetallePresenter
import com.alejandrazuleta.pruebaseleccion.presenter.DetallePresenterImpl
import kotlinx.android.synthetic.main.activity_detalle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleActivity : AppCompatActivity(), DetalleActivityView {

    private lateinit var postEntity : PostEntity

    private var usersItem:UsersItem?=null
    private var detallePresenter : DetallePresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        detallePresenter = DetallePresenterImpl(this)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        postEntity = intent?.getSerializableExtra("post") as PostEntity
        updateUI(postEntity)

        im_fav.setOnClickListener {
            if(!postEntity.fav){
                im_fav.setImageResource(R.drawable.baseline_favorite_black_24dp)
                detallePresenter!!.update(
                    postEntity.id,
                    postEntity.body,
                    postEntity.title,
                    postEntity.userId,
                    postEntity.user_Name,
                    postEntity.username,
                    postEntity.email,
                    postEntity.addressCity,
                    postEntity.phone,
                    postEntity.companyName,
                    postEntity.rating,
                    postEntity.read,
                    !postEntity.fav
                )
            }
        }

        ratingBar.setOnRatingBarChangeListener(
            object : RatingBar.OnRatingBarChangeListener{
                override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                    detallePresenter!!.update(
                        postEntity.id,
                        postEntity.body,
                        postEntity.title,
                        postEntity.userId,
                        postEntity.user_Name,
                        postEntity.username,
                        postEntity.email,
                        postEntity.addressCity,
                        postEntity.phone,
                        postEntity.companyName,
                        p1,
                        postEntity.read,
                        postEntity.fav
                    )
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

    private fun updateUI(postEntity: PostEntity) {
        if(postEntity.fav){
            im_fav.setImageResource(R.drawable.baseline_favorite_black_24dp)
            ratingBar.visibility= View.VISIBLE
            ratingBar.rating=postEntity.rating
        }else{
            im_fav.setImageResource(R.drawable.baseline_favorite_border_black_24dp)
        }
        tv_username.text=postEntity.username
        tv_nombre.text=postEntity.user_Name
        tv_email.text=postEntity.email
        tv_ciudad.text=postEntity.addressCity
        tv_telefono.text=postEntity.phone
        tv_companyname.text=postEntity.companyName
        tv_postTittle.text=postEntity.title
        tv_postBody.text=postEntity.body
    }
}
