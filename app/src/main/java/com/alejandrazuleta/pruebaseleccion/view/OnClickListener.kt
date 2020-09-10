package com.alejandrazuleta.pruebaseleccion.view

import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity

interface OnClickListener {
    fun onItemClick(postEntity: PostEntity)
}