package com.alejandrazuleta.pruebaseleccion.Model

interface DetalleInteractor {
    fun loadUserById(id:Int)
    fun insertFav(id:Int, body: String,title:String,userId:Int,username:String,rating:Float)
    fun update(id:Int, body: String,title:String,userId:Int,username:String,rating:Float)
}