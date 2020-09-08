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
    var userId: Int
): Serializable