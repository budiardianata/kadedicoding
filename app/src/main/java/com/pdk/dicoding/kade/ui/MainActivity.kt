package com.pdk.dicoding.kade.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pdk.dicoding.kade.R
import com.pdk.dicoding.kade.model.Liga
import com.pdk.dicoding.kade.ui.adapter.LigaAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        recyclerView.adapter = LigaAdapter(dataLiga()) {
            startActivity<DetailActivity>("data" to it)
        }
    }

    private fun dataLiga(): List<Liga> {
        val ligas: MutableList<Liga> = mutableListOf()
        val ids = resources.getIntArray(R.array.ids)
        val names = resources.getStringArray(R.array.name)
        val descriptions = resources.getStringArray(R.array.description)
        val images = resources.obtainTypedArray(R.array.image)
        for (i in ids.indices) {
            ligas.add(
                Liga(ids[i], names[i], descriptions[i], images.getResourceId(i, 0))
            )
        }
        images.recycle()
        return ligas
    }

    inner class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            constraintLayout {
                lparams(width = matchParent, height = matchParent)
                recyclerView = recyclerView {
                    layoutManager = GridLayoutManager(context, 2)
                }.lparams {
                    width = matchParent
                    height = matchParent
                }
            }
        }
    }
}