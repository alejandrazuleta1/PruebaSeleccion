package com.alejandrazuleta.pruebaseleccion.Model.Local

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class Repository {

    var postDAO = PruebaSeleccion.database.PostDAO()

    fun insertPostFavorite(
        id: Int,
        body: String,
        title: String,
        userId :Int,
        userName: String,
        rating : Float
    ){
        val post = PostEntity(id,body, title, userId,userName,rating)
        insertTask(post)
    }

    @SuppressLint("StaticFieldLeak")
    private fun insertTask(post: PostEntity) {
        object : AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void): Void? {
                postDAO.insertPost(post)
                return null
            }
        }.execute()
    }

    fun getFavoritesPosts():LiveData<List<PostEntity>>{
        return postDAO.getPosts()
    }

    fun update(post: PostEntity){
        updateTask(post)
    }

    @SuppressLint("StaticFieldLeak")
    private fun updateTask(post: PostEntity) {
        object : AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void): Void? {
                postDAO.updatePost(post)
                return null
            }
        }.execute()
    }

/*
    fun deletePostFavorite(id: Int) {
        //TODO("Not yet implemented")
    }



     */

}