package com.app.reart.view.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.reart.R
import com.app.reart.adapter.BoardListAdapter
import com.app.reart.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private val postAdapter: BoardListAdapter by lazy { BoardListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
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