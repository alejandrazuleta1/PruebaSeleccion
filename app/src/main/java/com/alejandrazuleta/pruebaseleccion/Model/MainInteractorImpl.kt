package com.alejandrazuleta.pruebaseleccion.Model

import android.util.Log
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.presenter.MainPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractorImpl(var mainPresenter: MainPresenter):MainInteractor {
    override fun loadListPost() {
        ApiService.create()
            .getPosts()
            .enqueue(object : Callback<Posts> {
                override fun onFailure(call: Call<Posts>, t: Throwable) {
                    mainPresenter.showErrorLoadPost(t.message)
                }

                override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                    if (response.isSuccessful) {
                        val repository = Repository()
                        val aux = response.body()!! as ArrayList<PostsItem>
                        var postEntityList : ArrayList<PostEntity>?=null
                        for(post in aux){
                            ApiService.create()
                                .getUserById(post.userId)
                                .enqueue(object : Callback<UsersItem> {
                                    override fun onFailure(call: Call<UsersItem>, t: Throwable) {
                                        Log.d("LoadListMainInteractor",t.message!!)
                                    }

                                    override fun onResponse(call: Call<UsersItem>, response: Response<UsersItem>) {
                                        if (response.isSuccessful) {
                                            var aux2: Boolean?=null
                                            if(aux.indexOf(post)<20) aux2=false
                                            else aux2=true
                                            val postEntity = PostEntity(
                                                post.id,
                                                post.body,
                                                post.title,
                                                post.userId,
                                                response.body()!!.name,
                                                response.body()!!.username,
                                                response.body()!!.email,
                                                response.body()!!.address.city,
                                                response.body()!!.phone,
                                                response.body()!!.company.name,
                                                0F,
                                                aux2,
                                                false)
                                            repository.insertPost(postEntity)
                                        }
                                    }
                                })
                        }
                        mainPresenter.loaded()
                    }
                }
            })
    }

    override fun deleteAll() {
        val repository = Repository()
        repository.deteleAll()
    }

}