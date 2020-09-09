package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem

interface HomePresenter {
    fun loadListPost()
    fun showErrorLoadPost(message: String?)
    fun sendListPosts(posts: List<PostsItem>)
}