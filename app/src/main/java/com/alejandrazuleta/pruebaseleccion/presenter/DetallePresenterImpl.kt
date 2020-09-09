package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.DetalleInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem
import com.alejandrazuleta.pruebaseleccion.view.DetalleActivityView

class DetallePresenterImpl(var detalleActivityView: DetalleActivityView) : DetallePresenter{

    private var detalleInteractor = DetalleInteractorImpl(this)

    override fun sendUser(usersItem: UsersItem) {
        detalleActivityView.sendUser(usersItem)
    }

    override fun loadUserById(id: Int) {
        detalleInteractor.loadUserById(id)
    }

    override fun insertFav(
        id: Int,
        body: String,
        title: String,
        userId: Int,
        username: String,
        rating: Float
    ) {
        detalleInteractor.insertFav(id,body,title,userId,username,rating)
    }

    override fun update(
        id: Int,
        body: String,
        title: String,
        userId: Int,
        username: String,
        rating: Float
    ) {
        detalleInteractor.update(id,body,title,userId,username,rating)
    }

}