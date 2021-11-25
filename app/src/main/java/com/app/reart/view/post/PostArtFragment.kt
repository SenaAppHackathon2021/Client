package com.app.reart.view.post

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.reart.R
import com.app.reart.adapter.PostArtAdapter
import com.app.reart.databinding.FragmentPostArtBinding
import com.app.reart.viewmodel.PostArtViewModel

class PostArtFragment : Fragment() {
    private lateinit var binding: FragmentPostArtBinding
    private lateinit var viewModel: PostArtViewModel

    private val galleryIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    private val GET_BEFORE_IMAGE_REQUEST = 0
    private val GET_AFTER_IMAGE_REQUEST = 1
    private var photoBeforeUri: Uri? = null
    private var photoAfterUri: Uri? = null

    private val mAdapter by lazy { PostArtAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[PostArtViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_art, container, false)

        binding.apply {
            lifecycleOwner = this@PostArtFragment
            recyclerviewSupporter.adapter = mAdapter

            buttonAddSupporter.setOnClickListener {
                val supporterName = binding.editSupporter.text.toString()

                if (supporterName.isBlank()) {
                    Toast.makeText(context, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.addSupporter(supporterName)
                    editSupporter.text.clear()
                }

                // 원래 DiffUtil 코드
                mAdapter.setData(viewModel.supporterList)

                // DiffUtil이 안먹어서 임시로 사용...
                mAdapter.notifyDataSetChanged()
            }

            buttonRemoveSupporter.setOnClickListener {
                viewModel.removeSupporter()

                // 원래 DiffUtil 코드
                mAdapter.setData(viewModel.supporterList)

                // DiffUtil이 안먹어서 임시로 사용...
                mAdapter.notifyDataSetChanged()
            }

            imageBefore.setOnClickListener {
                startActivityForResult(galleryIntent, GET_BEFORE_IMAGE_REQUEST)
            }
            imageAfter.setOnClickListener {
                startActivityForResult(galleryIntent, GET_AFTER_IMAGE_REQUEST)
            }
        }

        // 원래 DiffUtil 코드
        mAdapter.setData(viewModel.supporterList)

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GET_BEFORE_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            photoBeforeUri = data?.data

            binding.imageBefore.setImageURI(photoBeforeUri)
        }
        if (requestCode == GET_AFTER_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            photoAfterUri = data?.data

            binding.imageAfter.setImageURI(photoAfterUri)
        }
    }
}