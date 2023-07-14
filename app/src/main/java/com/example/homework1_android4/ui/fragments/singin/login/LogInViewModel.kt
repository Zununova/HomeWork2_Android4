package com.example.homework1_android4.ui.fragments.singin.login

import com.example.homework1_android4.base.BaseViewModel
import com.example.homework1_android4.data.models.login.LogDataModel
import com.example.homework1_android4.data.repositories.LogInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor( private val repository: LogInRepository ) : BaseViewModel(){

    fun fetchToken(logDataModel: LogDataModel) = repository.fetchToken(logDataModel)
}