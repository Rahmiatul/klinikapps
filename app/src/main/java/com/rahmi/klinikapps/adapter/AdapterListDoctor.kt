package com.rahmi.klinikapps.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahmi.klinikapps.detailDoctor
import com.rahmi.klinikapps.model.ModelListDoctor
import com.rahmi.klinikapps.R

class AdapterListDoctor (
    private var context: Context, // Ganti urutan: context lebih dulu
    val itemDoctorList: List<ModelListDoctor>
) : RecyclerView.Adapter<AdapterListDoctor.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgDoctor: ImageView = itemView.findViewById(R.id.imgDoctor2)
        val nameDoctor: TextView = itemView.findViewById(R.id.nameDoctor)
        val bidangDoctor: TextView = itemView.findViewById(R.id.bidangDoctor)
        val totalReview: TextView = itemView.findViewById(R.id.totalReview)
        val angkaReview: TextView = itemView.findViewById(R.id.angkaReview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.imgDoctor.setImageResource(currentItem.ImageDr)
        holder.nameDoctor.text = currentItem.NamaDr
        holder.bidangDoctor.text = currentItem.BidangDr
        holder.totalReview.text = currentItem.totalReview
        holder.angkaReview.text = currentItem.angkaReview

        holder.itemView.setOnClickListener {
            val intent = Intent(context, detailDoctor::class.java)
            intent.putExtra("ImageDr", currentItem.ImageDr)
            intent.putExtra("NamaDr", currentItem.NamaDr)
            intent.putExtra("BidangDr", currentItem.BidangDr)
            intent.putExtra("totalReview", currentItem.totalReview)
            intent.putExtra("angkaReview", currentItem.angkaReview)
            intent.putExtra("date", currentItem.date)
            intent.putExtra("time", currentItem.time)

            context.startActivity(intent)
        }
    }
}