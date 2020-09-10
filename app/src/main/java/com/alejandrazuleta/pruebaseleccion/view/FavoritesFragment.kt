package com.alejandrazuleta.pruebaseleccion.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.R
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class FavoritesFragment: Fragment() {

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
        repository.getPostFavorites().observe(this, Observer {
            root.recyclerView.adapter = FavoritesPostsAdapter(it!! as java.util.ArrayList<PostEntity>)
        })
    }

}