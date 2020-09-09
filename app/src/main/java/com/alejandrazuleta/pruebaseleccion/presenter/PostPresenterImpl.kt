package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.PostInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.view.PostView

class PostPresenterImpl (var postView: PostView) : PostPresenter {
    private var postInteractor = PostInteractorImpl(this)

    override fun loadListPost() {
        postInteractor.loadListPost()
    }

    override fun showErrorLoadPost(message: String?) {
        postView.showErrorLoadPost(message)
    }

    override fun sendListPosts(posts: List<PostsItem>) {
        postView.sendListPosts(posts)
    }
}