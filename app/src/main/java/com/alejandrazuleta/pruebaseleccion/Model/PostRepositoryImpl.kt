package com.alejandrazuleta.pruebaseleccion.Model

import com.alejandrazuleta.pruebaseleccion.presenter.PostPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepositoryImpl(var postPresenter: PostPresenter):PostRepository{
    override fun loadListPost() {
        ApiService.create()
            .getPosts()
            .enqueue(object : Callback<Posts> {
                override fun onFailure(call: Call<Posts>, t: Throwable) {
                    postPresenter.showErrorLoadPost(t.message)
                }

                override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                    if (response.isSuccessful) {
                        postPresenter.sendListPosts(response.body()!! as ArrayList<PostsItem>)
                    }
                }
            })
    }
}