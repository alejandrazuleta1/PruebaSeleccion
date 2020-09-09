package com.alejandrazuleta.pruebaseleccion.Model

import com.alejandrazuleta.pruebaseleccion.presenter.HomePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostInteractorImpl(var homePresenter: HomePresenter):PostInteractor{
    override fun loadListPost() {
        ApiService.create()
            .getPosts()
            .enqueue(object : Callback<Posts> {
                override fun onFailure(call: Call<Posts>, t: Throwable) {
                    homePresenter.showErrorLoadPost(t.message)
                }

                override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                    if (response.isSuccessful) {
                        homePresenter.sendListPosts(response.body()!! as ArrayList<PostsItem>)
                    }
                }
            })
    }

}