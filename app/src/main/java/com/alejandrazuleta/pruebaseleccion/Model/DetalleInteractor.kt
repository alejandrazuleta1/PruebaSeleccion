package com.alejandrazuleta.pruebaseleccion.Model

interface DetalleInteractor {
    fun update( id: Int,
                body: String,
                title: String,
                userId: Int,
                user_Name: String,
                username: String,
                email: String,
                city:String,
                phone:String,
                companyName:String,
                rating: Float,
                read :Boolean,
                fav :Boolean)
}