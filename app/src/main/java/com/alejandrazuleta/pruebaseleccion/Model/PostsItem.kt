package com.alejandrazuleta.pruebaseleccion.Model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostsItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
): Serializable