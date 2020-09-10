package com.alejandrazuleta.pruebaseleccion.Model.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "posts_entity")
class PostEntity (
    @PrimaryKey var id: Int,
    var body: String,
    var title: String,
    var userId: Int,
    var user_Name: String,
    var username: String,
    var email: String,
    var addressCity: String,
    var phone: String,
    var companyName: String,
    var rating : Float,
    var read : Boolean,
    var fav :Boolean
): Serializable