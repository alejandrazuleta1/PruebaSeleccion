package com.alejandrazuleta.pruebaseleccion.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostDAO {
    @Query("SELECT * FROM posts_entity")
    fun getPosts():LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(postEntity: PostEntity)

    @Update
    fun updatePost(postEntity: PostEntity)
}