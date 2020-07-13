package com.pdk.dicoding.kade.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdk.dicoding.kade.R
import com.pdk.dicoding.kade.model.Liga
import com.pdk.dicoding.kade.ui.adapter.itemLayout.ItemLigaLayout
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find


/**
 * Created by Budi Ardianata on 13/07/2020.
 * Project: KADE
 * Email: budiardianata@windowslive.com
 */
class LigaAdapter(private val ligas :List<Liga>, private val clickListener: (Liga) -> Unit) : RecyclerView.Adapter<LigaAdapter.LigaViewHolder>()  {
    class LigaViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(liga: Liga, clickListener:(Liga) -> Unit) {
            val name = itemView.find<TextView>(R.id.name)
            val imageView = itemView.find<ImageView>(R.id.image)

            name.text = liga.name
            imageView.setImageResource(liga.image)
            itemView.setOnClickListener{
                clickListener(liga)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewHolder {
        return LigaViewHolder(
            ItemLigaLayout()
                .createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = ligas.size

    override fun onBindViewHolder(holder: LigaViewHolder, position: Int) {
        holder.bind(ligas[position], clickListener)
    }
}