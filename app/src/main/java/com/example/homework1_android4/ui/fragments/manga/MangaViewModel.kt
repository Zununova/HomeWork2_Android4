package com.example.homework1_android4.ui.fragments.manga

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework1_android4.base.BaseViewModel
import com.example.homework1_android4.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {

    fun fetchManga() = repository.fetchManga().cachedIn(viewModelScope)
}