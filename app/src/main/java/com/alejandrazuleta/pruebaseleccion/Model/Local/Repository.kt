package com.alejandrazuleta.pruebaseleccion.Model.Local

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class Repository {

    var postDAO = PruebaSeleccion.database.PostDAO()

    fun insertPost(post: PostEntity
    ){
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

    fun getPost():LiveData<List<PostEntity>>{
        return postDAO.getPosts()
    }

    fun getPostFavorites():LiveData<List<PostEntity>>{
        return postDAO.getPostsFavorites()
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

    fun deteleAll(){
        deleteTask()
    }

    @SuppressLint("StaticFieldLeak")
    private fun deleteTask() {
        object : AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void): Void? {
                postDAO.deleteAll()
                return null
            }
        }.execute()
    }

}