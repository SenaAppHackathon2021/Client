package com.app.reart.view.fragments.artboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.app.reart.R
import com.app.reart.databinding.FragmentArtBoardBinding

class ArtBoardFragment : Fragment() {
    private lateinit var binding: FragmentArtBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_art_board, container, false)



        return binding.root
    }
}