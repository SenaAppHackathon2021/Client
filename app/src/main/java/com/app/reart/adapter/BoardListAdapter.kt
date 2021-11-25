package com.app.reart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.reart.R
import com.app.reart.databinding.ItemArtBoardBinding
import com.app.reart.model.BoardItem

class BoardListAdapter: RecyclerView.Adapter<BoardListAdapter.BoardListViewHolder>() {
    var postList: ArrayList<BoardItem> = arrayListOf()

    class BoardListViewHolder(private var binding: ItemArtBoardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BoardItem) {
            // TODO : Update image loading logic
            binding.imageThumb.setImageResource(item.thumbnailSrc ?: R.drawable.re_art_logo)
            binding.textTitle.text = item.title
            binding.textAuthor.text = "요청자 : ${item.author}"
            binding.textDate.text = item.date
        }

        companion object {
            fun from(parent: ViewGroup): BoardListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemArtBoardBinding.inflate(layoutInflater, parent, false)

                return BoardListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListViewHolder = BoardListViewHolder.from(parent)

    override fun onBindViewHolder(holder: BoardListViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    fun setData(newPostList: List<BoardItem>) {
        postList = ArrayList(newPostList)

        notifyDataSetChanged()
    }
}