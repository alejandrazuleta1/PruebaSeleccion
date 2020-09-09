package com.alejandrazuleta.pruebaseleccion.view

import com.alejandrazuleta.pruebaseleccion.Model.PostsItem

interface HomeFragmentView {
    fun showErrorLoadPost(message: String?)
    fun sendListPosts(posts: List<PostsItem>)
}