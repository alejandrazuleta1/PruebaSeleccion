package com.alejandrazuleta.pruebaseleccion.view

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.ApiService
import com.alejandrazuleta.pruebaseleccion.Model.Posts
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.R
import com.alejandrazuleta.pruebaseleccion.presenter.PostPresenter
import com.alejandrazuleta.pruebaseleccion.presenter.PostPresenterImpl
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment: Fragment(),PostView {

    private var postPresenter : PostPresenter?=null
    private var listPosts : List<PostsItem> ?=null
    private lateinit var root : View

    //private lateinit var postAdapter : PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home,container,false)
        setHasOptionsMenu(true)
        postPresenter = PostPresenterImpl(this)
        getPost()

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_listado,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mo_eliminar->{

            }
            R.id.mo_actualizar->{

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getPost() {
        postPresenter?.loadListPost()
    }

    override fun showErrorLoadPost(message: String?) {
        Log.d("LoadPost",message!!)
    }

    override fun sendListMovies(posts: List<PostsItem>) {
        this.listPosts = posts
        root.recyclerView.setHasFixedSize(true)
        root.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        val postAdapter = PostAdapter(listPosts as ArrayList<PostsItem>)
        root.recyclerView.adapter=postAdapter
    }


}