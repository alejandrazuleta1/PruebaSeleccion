package com.alejandrazuleta.pruebaseleccion.presenter

import com.alejandrazuleta.pruebaseleccion.Model.UsersItem

interface DetallePresenter {
    fun sendUser(usersItem: UsersItem)
    fun loadUserById(id:Int)
    fun insertFav(id:Int, body: String,title:String,userId:Int,username:String,rating:Float)
    fun update(id:Int, body: String,title:String,userId:Int,username:String,rating:Float)
}