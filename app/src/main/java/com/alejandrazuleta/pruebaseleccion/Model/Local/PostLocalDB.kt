package com.alejandrazuleta.pruebaseleccion.Model.Local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PostEntity::class),version=8)
abstract class PostLocalDB : RoomDatabase(){
    abstract fun PostDAO():PostDAO
}