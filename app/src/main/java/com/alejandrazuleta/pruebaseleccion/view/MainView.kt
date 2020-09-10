package com.alejandrazuleta.pruebaseleccion.view

import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem

interface MainView {
    fun showErrorLoadPost(message: String?)
    fun showProgresBar()
    fun hideProgresBar()
}