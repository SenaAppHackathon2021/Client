package com.app.reart.view.fragments.artboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.reart.R
import com.app.reart.adapter.BoardListAdapter
import com.app.reart.databinding.FragmentArtBoardBinding
import com.app.reart.view.fragments.home.HomeViewModel

class ArtBoardFragment : Fragment() {
    private lateinit var binding: FragmentArtBoardBinding
    private lateinit var viewModel: ArtBoardViewModel
    private val postAdapter: BoardListAdapter by lazy { BoardListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_art_board, container, false)
        viewModel = ViewModelProvider(requireActivity())[ArtBoardViewModel::class.java]
        binding.postRecyclerView.adapter = postAdapter

        viewModel.getPosts()

        observeData()

        return binding.root
    }

    private fun observeData() {
        viewModel.postResponse.observe(this, { postList ->
            postAdapter.setData(postList)
        })
    }
}