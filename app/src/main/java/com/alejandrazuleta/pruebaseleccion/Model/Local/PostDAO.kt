package com.alejandrazuleta.pruebaseleccion.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDAO {
    @Query("SELECT * FROM posts_entity")
    fun getPosts():LiveData<List<PostEntity>>

    @Insert
    fun insertPost(postEntity: PostEntity)
}