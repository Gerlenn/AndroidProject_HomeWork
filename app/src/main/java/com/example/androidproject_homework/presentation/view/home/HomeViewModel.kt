package com.example.androidproject_homework.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_homework.domain.auth.AuthInteractor
import com.example.androidproject_homework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
) : ViewModel() {

    private val _userCred = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCred

    fun showUserData() {
        _userCred.value = authInteractor.getUserCreds()
    }
}