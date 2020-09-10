package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.DetalleInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem
import com.alejandrazuleta.pruebaseleccion.view.DetalleActivityView

class DetallePresenterImpl(var detalleActivityView: DetalleActivityView) : DetallePresenter{

    private var detalleInteractor = DetalleInteractorImpl(this)

    override fun update(id: Int,
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
        detalleInteractor.update(id,body,title,userId,user_Name,username,email,city,phone,companyName,rating,read,fav)
    }

}