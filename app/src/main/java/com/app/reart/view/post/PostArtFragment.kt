package com.app.reart.view.post

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Base64.NO_WRAP
import android.util.Log
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
import com.app.reart.model.ArtPost
import com.app.reart.model.Picture
import com.app.reart.viewmodel.PostArtViewModel
import java.io.ByteArrayOutputStream
import java.io.InputStream

class PostArtFragment : Fragment() {
    private lateinit var binding: FragmentPostArtBinding
    private lateinit var viewModel: PostArtViewModel

    private val GET_BEFORE_IMAGE_REQUEST = 0
    private val GET_AFTER_IMAGE_REQUEST = 1
    private val galleryIntent =
        Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)


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
                    makeToast("이름을 입력해주세요")
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

            // 게시물 제출 버튼
            buttonSubmit.setOnClickListener {
                if (editTitle.text.isBlank())
                    makeToast("제목을 입력해주세요")
                else if (editContent.text.isBlank())
                    makeToast("내용을 입력해주세요")

                val post = ArtPost(
                    editTitle.text.toString(),
                    editContent.text.toString(),
                    Picture(
                        viewModel.photoBeforeBase64,
                        viewModel.photoAfterBase64
                    ),
                    viewModel.supporterList
                )

                viewModel.uploadPost(post)

                makeToast("게시물을 올렸습니다!")
            }
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GET_BEFORE_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            viewModel.photoBeforeUri = data?.data
            viewModel.photoBeforeBase64 = getBase64StringOf(data)

            binding.imageBefore.setImageURI(viewModel.photoBeforeUri)
        }
        if (requestCode == GET_AFTER_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            viewModel.photoAfterUri = data?.data
            viewModel.photoAfterBase64 = getBase64StringOf(data)

            binding.imageAfter.setImageURI(viewModel.photoAfterUri)
        }
    }

    private fun getBase64StringOf(intent: Intent?): String {
        val currentImageURL = intent?.data

        // Base64 인코딩부분
        val ins: InputStream? = currentImageURL?.let {
            activity!!.applicationContext.contentResolver.openInputStream(it)
        }
        val img: Bitmap = BitmapFactory.decodeStream(ins)
        ins?.close()

        val resized = Bitmap.createScaledBitmap(img, 256, 256, true)
//        val resized = Bitmap.createBitmap(img)

        val byteArrayOutputStream = ByteArrayOutputStream()
        resized.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream)
        val byteArray: ByteArray = byteArrayOutputStream.toByteArray()

        val result = Base64.encodeToString(byteArray, NO_WRAP)

        Log.d("getBase64StringOf", result)

        return result
    }

    private fun makeToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}