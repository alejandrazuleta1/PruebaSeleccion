package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.PostInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.view.HomeFragmentView

class HomePresenterImpl (var homeFragmentView: HomeFragmentView) : HomePresenter {
    private var postInteractor = PostInteractorImpl(this)

    override fun loadListPost() {
        postInteractor.loadListPost()
    }

    override fun showErrorLoadPost(message: String?) {
        homeFragmentView.showErrorLoadPost(message)
    }

    override fun sendListPosts(posts: List<PostsItem>) {
        homeFragmentView.sendListPosts(posts)
    }
}