package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.PostsItem

interface PostPresenter {
    fun loadListPost()
    fun showErrorLoadPost(message: String?)
    fun sendListPosts(posts: List<PostsItem>)
}