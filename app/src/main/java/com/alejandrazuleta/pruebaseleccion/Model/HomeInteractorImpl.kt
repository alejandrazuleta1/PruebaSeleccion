package com.alejandrazuleta.pruebaseleccion.Model

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.presenter.HomePresenter

class HomeInteractorImpl(var homePresenter: HomePresenter):HomeInteractor{
    override fun update(postEntity: PostEntity) {
        val repository=Repository()
        repository.update(postEntity)
    }
}