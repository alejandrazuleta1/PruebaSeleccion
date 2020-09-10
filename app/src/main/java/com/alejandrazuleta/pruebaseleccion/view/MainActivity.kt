package com.alejandrazuleta.pruebaseleccion.view

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.PostsItem
import com.alejandrazuleta.pruebaseleccion.Model.UsersItem
import com.alejandrazuleta.pruebaseleccion.R
import com.alejandrazuleta.pruebaseleccion.presenter.MainPresenter
import com.alejandrazuleta.pruebaseleccion.presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(), MainView{

    private var mainPresenter : MainPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenterImpl(this)
        getPosts()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val homeFragment = HomeFragment()
        transaction.add(R.id.contenedor, homeFragment).commit()

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    private fun getPosts() {
        mainPresenter?.loadListPost()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId){
            R.id.mo_all -> {
                val homeFragment =
                    HomeFragment()
                transaction.replace(R.id.contenedor, homeFragment).commit()
            }
            R.id.mo_fav -> {
                val favoritesFragment =
                    FavoritesFragment()
                transaction.replace(R.id.contenedor, favoritesFragment).commit()
            }
            R.id.mo_actualizar->{
                getPosts()
            }
            R.id.mo_eliminar->{
                mainPresenter!!.deleteAll()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showErrorLoadPost(message: String?) {
        Log.d("LoadPost", message!!)
    }


}