package com.alejandrazuleta.pruebaseleccion.Model.Local

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alejandrazuleta.pruebaseleccion.Model.Local.PruebaSeleccion.Companion.database

class PruebaSeleccion : Application() {
    companion object{
        lateinit var database:PostLocalDB
    }

    override fun onCreate() {
        super.onCreate()
        PruebaSeleccion.database = Room.databaseBuilder(
            this,
            PostLocalDB::class.java,
            "posts_entity"
        ).build()
    }
}