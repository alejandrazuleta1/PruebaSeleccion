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
        userId: Int
    ){
        val post = PostEntity(id,body, title, userId)
        insertTask(post)
    }

    private fun insertTask(post: PostEntity) {
        object : AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void): Void? {
                postDAO.insertPost(post)
                return null
            }
        }.execute()
    }

    fun deletePostFavorite(id: Int) {
        //TODO("Not yet implemented")
    }

    fun getFavoritesPosts():LiveData<List<PostEntity>>{
        return postDAO.getPosts()
    }

}