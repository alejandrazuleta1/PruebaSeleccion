package com.alejandrazuleta.pruebaseleccion.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.pruebaseleccion.Model.Local.PostEntity
import com.alejandrazuleta.pruebaseleccion.Model.Local.Repository
import com.alejandrazuleta.pruebaseleccion.R
import com.alejandrazuleta.pruebaseleccion.presenter.HomePresenter
import com.alejandrazuleta.pruebaseleccion.presenter.HomePresenterImpl
import kotlinx.android.synthetic.main.fragment_home.view.recyclerView


class HomeFragment: Fragment(),HomeFragmentView,OnClickListener {

    private var homePresenter : HomePresenter?=null

    private lateinit var postAdapter: PostAdapter
    private lateinit var root : View
    private lateinit var deleteIcon:Drawable
    private var swipeBackground:ColorDrawable = ColorDrawable(Color.parseColor("#FF0000"))


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        homePresenter = HomePresenterImpl(this)
        loadListPost()

        deleteIcon= ContextCompat.getDrawable(
            activity!!.applicationContext,
            R.drawable.ic_delete_white_24dp
        )!!

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                postAdapter.removeItem(viewHolder)
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemView = viewHolder.itemView
                val iconMarginVertical = (viewHolder.itemView.height - deleteIcon.intrinsicHeight) / 2

                if(dX>0){
                    swipeBackground.setBounds(
                        itemView.left,
                        itemView.top,
                        dX.toInt(),
                        itemView.bottom
                    )
                    deleteIcon.setBounds(
                        itemView.left + iconMarginVertical,
                        itemView.top + iconMarginVertical,
                        itemView.left + iconMarginVertical + deleteIcon.intrinsicWidth,
                        itemView.bottom - iconMarginVertical
                    )
                }else{
                    swipeBackground.setBounds(
                        itemView.right + dX.toInt(),
                        itemView.top,
                        itemView.right,
                        itemView.bottom
                    )
                    deleteIcon.setBounds(
                        itemView.right - iconMarginVertical - deleteIcon.intrinsicWidth,
                        itemView.top + iconMarginVertical,
                        itemView.right - iconMarginVertical,
                        itemView.bottom - iconMarginVertical
                    )
                    deleteIcon.level = 0
                }
                swipeBackground.draw(c)
                c.save()

                if (dX > 0)
                    c.clipRect(itemView.left, itemView.top, dX.toInt(), itemView.bottom)
                else
                    c.clipRect(
                        itemView.right + dX.toInt(),
                        itemView.top,
                        itemView.right,
                        itemView.bottom
                    )

                deleteIcon.draw(c)

                c.restore()

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(root.recyclerView)

        root.recyclerView.setHasFixedSize(true)
        root.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )

        return root
    }

    private fun loadListPost() {
        val repository = Repository()
        repository.getPost().observe(this, Observer {
            postAdapter=PostAdapter(it!! as java.util.ArrayList<PostEntity>,this)
            root.recyclerView.adapter = postAdapter
        })
    }

    fun update(postEntity: PostEntity) {
        homePresenter!!.update(postEntity)
    }

    override fun onItemClick(postEntity: PostEntity) {
        update(postEntity)
    }

}