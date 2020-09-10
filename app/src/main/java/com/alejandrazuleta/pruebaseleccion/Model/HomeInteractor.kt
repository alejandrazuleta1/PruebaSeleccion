package com.alejandrazuleta.pruebaseleccion.Model

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity

interface HomeInteractor {
    fun update(postEntity: PostEntity)
}