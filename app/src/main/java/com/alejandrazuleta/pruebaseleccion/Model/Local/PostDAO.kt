package com.alejandrazuleta.pruebaseleccion.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostDAO {
    @Query("SELECT * FROM posts_entity")
    fun getPosts():LiveData<List<PostEntity>>

    @Query("SELECT * FROM posts_entity WHERE fav='1'")
    fun getPostsFavorites():LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(postEntity: PostEntity)

    @Update
    fun updatePost(postEntity: PostEntity)

    @Query("DELETE FROM posts_entity")
    fun deleteAll()
}