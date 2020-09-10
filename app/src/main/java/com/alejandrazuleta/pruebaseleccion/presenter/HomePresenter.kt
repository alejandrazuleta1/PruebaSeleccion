package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem

interface HomePresenter {
    fun update(postEntity: PostEntity)
}