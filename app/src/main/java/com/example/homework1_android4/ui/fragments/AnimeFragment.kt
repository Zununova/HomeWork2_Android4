package com.example.homework1_android4.ui.fragments

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.base.BaseFragment
import com.example.homework1_android4.data.repositories.AnimeRepository
import com.example.homework1_android4.databinding.FragmentAnimeBinding
import com.example.homework1_android4.ui.adapters.AnimeAdapter
import com.example.homework1_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClick)

    private fun onClick(id: Int) {
        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToDetailAnimeFragment(id)
        )
    }

    override fun initialize() {
        super.initialize()
        binding.recyclerViewAnime.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchAnime().observe(requireActivity()) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "error")
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "loading")
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.animeList)
                }
            }
        }
    }

    override fun setupListener() {
        super.setupListener()

    }
}