package com.app.reart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArtsAdapter(val artsList: ArrayList<Arts>) : RecyclerView.Adapter<ArtsAdapter.ArtsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtsAdapter.ArtsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.arts_list_item,parent,false)
        return ArtsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtsAdapter.ArtsViewHolder, position: Int) {
        holder.artWork.setImageResource(artsList.get(position).picture)
        holder.title.text = artsList.get(position).title
        holder.writer.text = artsList.get(position).artist
        holder.time.text = artsList.get(position).created_time.toString()
    }

    override fun getItemCount(): Int {
        return artsList.size
    }
    class ArtsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val artWork = itemView.findViewById<ImageView>(R.id.iv_artwork)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val writer = itemView.findViewById<TextView>(R.id.tv_writer)
        val time = itemView.findViewById<TextView>(R.id.tv_time)
    }

}