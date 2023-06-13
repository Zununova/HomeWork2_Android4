package com.example.homework1_android4.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.homework1_android4.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun fetchAnime() = repository.fetchAnime()

}