package com.alejandrazuleta.pruebaseleccion.Model

import android.util.Log
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.presenter.DetallePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleInteractorImpl(var detallePresenter: DetallePresenter) : DetalleInteractor{

    override fun update(
        id: Int,
        body: String,
        title: String,
        userId: Int,
        user_Name: String,
        username: String,
        email: String,
        city:String,
        phone:String,
        companyName:String,
        rating: Float,
        read :Boolean,
        fav :Boolean
    ) {
        val repository = Repository()
        repository.update(PostEntity(id,body,title,userId,user_Name,username,email,city,phone,companyName,rating,read,fav))
    }
}