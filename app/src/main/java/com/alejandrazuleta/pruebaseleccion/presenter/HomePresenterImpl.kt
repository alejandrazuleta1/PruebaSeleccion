package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.HomeInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.view.HomeFragmentView

class HomePresenterImpl (var homeFragmentView: HomeFragmentView) : HomePresenter {
    private var homeInteractor = HomeInteractorImpl(this)
    override fun update(postEntity: PostEntity) {
        homeInteractor.update(postEntity)
    }
}