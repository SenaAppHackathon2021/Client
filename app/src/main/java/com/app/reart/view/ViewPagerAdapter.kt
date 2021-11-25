package com.app.reart.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.reart.R

class ViewPagerAdapter(val artList: ArrayList<BeAf>) : RecyclerView.Adapter<ViewPagerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_list_item,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.CustomViewHolder, position: Int) {
        holder.before.setImageResource(artList.get(position%4).before)
        holder.after.setImageResource(artList.get(position%4).after)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val before = itemView.findViewById<ImageView>(R.id.iv_before)
        val after = itemView.findViewById<ImageView>(R.id.iv_after)
    }
}