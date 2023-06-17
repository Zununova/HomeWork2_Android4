package com.example.homework1_android4.ui.fragments.home.anime

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.base.BaseFragment
import com.example.homework1_android4.databinding.FragmentAnimeBinding
import com.example.homework1_android4.ui.adapters.AnimeAdapter
import com.example.homework1_android4.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClick)

    private fun onClick(id: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailAnimeFragment(
                id.plus(1)
            )
        )
    }


    override fun initialize() {
        super.initialize()
        binding.recyclerViewAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {

        lifecycleScope.launch {
            viewModel.fetchAnime().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    animeAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
    }
}