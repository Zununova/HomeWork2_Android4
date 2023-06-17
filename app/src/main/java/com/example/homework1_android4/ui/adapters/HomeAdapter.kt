package com.example.homework1_android4.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework1_android4.ui.fragments.home.anime.AnimeFragment
import com.example.homework1_android4.ui.fragments.home.manga.MangaFragment

class HomeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            else -> MangaFragment()
        }
    }
}