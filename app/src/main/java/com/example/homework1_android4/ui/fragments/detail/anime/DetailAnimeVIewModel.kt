package com.example.homework1_android4.ui.fragments.detail.anime

import com.example.homework1_android4.base.BaseViewModel
import com.example.homework1_android4.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeVIewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun fetchIdAnime(id: Int) = repository.fetchIdAnime(id)
}