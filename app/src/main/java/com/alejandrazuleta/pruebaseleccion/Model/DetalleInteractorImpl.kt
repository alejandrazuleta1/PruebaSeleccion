package com.alejandrazuleta.pruebaseleccion.Model

import android.util.Log
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.presenter.DetallePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleInteractorImpl(var detallePresenter: DetallePresenter) : DetalleInteractor{

    override fun loadUserById(id: Int) {
        ApiService.create()
            .getUserById(id)
            .enqueue(object : Callback<UsersItem> {
                override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                    val usersItem =response.body() as UsersItem
                    detallePresenter.sendUser(usersItem)
                }
                override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                    Log.d("ErrorLoadUserById",t.message!!)
                }

            })
    }

    override fun insertFav(id:Int, body: String,title:String,userId:Int,username:String,rating:Float) {
        val repository = Repository()
        repository.insertPostFavorite(id,body,title,userId,username,rating)
    }

    override fun update(
        id: Int,
        body: String,
        title: String,
        userId: Int,
        username: String,
        rating: Float
    ) {
        val repository = Repository()
        repository.update(PostEntity(id,body,title,userId,username,rating))
    }
}