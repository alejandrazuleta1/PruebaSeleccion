package com.alejandrazuleta.pruebaseleccion.view

import com.alejandrazuleta.pruebaseleccion.Model.PostsItem

interface PostView {
    fun showErrorLoadPost(message: String?)
    fun sendListMovies(posts: List<PostsItem>)
}