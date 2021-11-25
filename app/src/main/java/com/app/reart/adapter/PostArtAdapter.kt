package com.app.reart.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.reart.databinding.ItemSupporterBinding
import com.app.reart.util.PostArtDiffUtil

class PostArtAdapter : RecyclerView.Adapter<PostArtAdapter.PostArtViewHolder>() {
    private var supporterList = emptyList<String>()

    class PostArtViewHolder(private val binding: ItemSupporterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(supporter: String) {
            binding.textSupporter.text = supporter
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PostArtViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSupporterBinding.inflate(layoutInflater, parent, false)

                return PostArtViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostArtViewHolder = PostArtViewHolder.from(parent)


    override fun onBindViewHolder(holder: PostArtViewHolder, position: Int) {
        holder.bind(supporterList[position])
    }

    override fun getItemCount(): Int = supporterList.size

    fun setData(newSupporterList: List<String>) {
        val postArtDiffUtil = PostArtDiffUtil(supporterList, newSupporterList)
        val diffUtilResult = DiffUtil.calculateDiff(postArtDiffUtil)

        supporterList = newSupporterList

        Log.d("TAG", "setData: Called!")

        diffUtilResult.dispatchUpdatesTo(this)
    }
}