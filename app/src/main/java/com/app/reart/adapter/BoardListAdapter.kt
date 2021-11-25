package com.app.reart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.reart.databinding.ItemArtBoardBinding
import com.app.reart.model.ArtBoardItem

class BoardListAdapter: RecyclerView.Adapter<BoardListAdapter.HomeListViewHolder>() {
    var postList: ArrayList<ArtBoardItem> = arrayListOf()

    class HomeListViewHolder(private var binding: ItemArtBoardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArtBoardItem) {

            binding.textTitle.text = item.title
            binding.textAuthor.text = "요청자 : ${item.author}"
            binding.textDate.text = item.date
        }

        companion object {
            fun from(parent: ViewGroup): HomeListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemArtBoardBinding.inflate(layoutInflater, parent, false)

                return HomeListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder = HomeListViewHolder.from(parent)

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    fun setData(newPostList: List<ArtBoardItem>) {
        postList = ArrayList(newPostList)

        notifyDataSetChanged()
    }
}