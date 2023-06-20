package com.example.homework1_android4.ui.fragments.detail.manga

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework1_android4.R
import com.example.homework1_android4.base.BaseFragment
import com.example.homework1_android4.databinding.FragmentMangaDetailBinding
import com.example.homework1_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, DetailMangaViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: DetailMangaViewModel by viewModels()

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        val args by navArgs<MangaDetailFragmentArgs>()
        viewModel.fetchMangaById(args.id + 1).observe(requireActivity()) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    binding.textViewDetail.text = it.data?.animeModel?.attributes?.detail
                    Glide.with(binding.imageViewPoster)
                        .load(it.data?.animeModel?.attributes?.image?.image)
                        .into(binding.imageViewPoster)
                    binding.textView.text = it.data?.animeModel?.attributes?.title?.title
                }
            }
        }
    }

}
