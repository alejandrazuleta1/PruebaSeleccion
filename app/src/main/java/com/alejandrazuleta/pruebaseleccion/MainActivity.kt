package com.alejandrazuleta.pruebaseleccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val homeFragment = HomeFragment()
        transaction.add(R.id.contenedor, homeFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId){
            R.id.mo_eliminar -> {

            }
            R.id.mo_actualizar -> {

            }
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
        }

        return super.onOptionsItemSelected(item)
    }


}