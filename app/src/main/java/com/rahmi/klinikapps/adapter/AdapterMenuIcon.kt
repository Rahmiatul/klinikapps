package com.rahmi.klinikapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahmi.klinikapps.R
import com.rahmi.klinikapps.model.ModelIcon


class AdapterMenuIcon (
    val itemMenuList: List<ModelIcon>) :
    RecyclerView.Adapter<AdapterMenuIcon.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenuIcon: ImageView = itemView.findViewById(R.id.imgMenu)
        val txtNamaMenu: TextView = itemView.findViewById(R.id.txtnameMenu)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int
    {
        return itemMenuList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenuList[position]
        holder.imgMenuIcon.setImageResource(currentItem.icon)
        holder.txtNamaMenu.setText(currentItem.iconName)
    }




}