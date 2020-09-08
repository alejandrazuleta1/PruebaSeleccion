package com.alejandrazuleta.pruebaseleccion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class FavoritesFragment: Fragment() {

    private var listPosts = ArrayList<PostsItem>()
    private lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_favorites,container,false)
        loadListFavoritesPost()
        root.recyclerView.setHasFixedSize(true)
        root.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        return root
    }

    private fun loadListFavoritesPost() {
        val repository = Repository()
        repository.getFavoritesPosts().observe(this, Observer {
            root.recyclerView.adapter = PostsFavoritesAdapter(it!! as java.util.ArrayList<PostEntity>)
        })
    }

}