package com.alejandrazuleta.pruebaseleccion.Model

import com.alejandrazuleta.pruebaseleccion.presenter.PostPresenter

class PostInteractorImpl(var postPresenter: PostPresenter):PostInteractor{
    private var postRepository = PostRepositoryImpl(postPresenter)
    override fun loadListPost() {
        postRepository.loadListPost()
    }
}