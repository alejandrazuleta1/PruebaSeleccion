package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.MainInteractor
import com.alejandrazuleta.pruebaseleccion.Model.MainInteractorImpl
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem
import com.alejandrazuleta.pruebaseleccion.view.MainView

class MainPresenterImpl (var mainView: MainView):MainPresenter{

    var mainInteractor = MainInteractorImpl(this)

    override fun loadListPost() {
        mainView.showProgresBar()
        mainInteractor.loadListPost()
    }

    override fun loaded() {
        mainView.hideProgresBar()
    }


    override fun showErrorLoadPost(message: String?) {
        mainView.showErrorLoadPost(message)
    }

    override fun deleteAll() {
        mainInteractor.deleteAll()
    }
}