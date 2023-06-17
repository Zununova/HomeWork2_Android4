package com.example.homework1_android4.ui.fragments.detail.manga

import com.example.homework1_android4.base.BaseViewModel
import com.example.homework1_android4.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {

    fun fetchMangaById(id: Int) = repository.fetchMangaById(id)
}