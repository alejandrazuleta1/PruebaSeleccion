package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem

interface MainPresenter {
    fun loadListPost()
    fun showErrorLoadPost(message: String?)
    fun deleteAll()
}