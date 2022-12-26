package com.example.androidproject_homework.presentation.view

import com.example.androidproject_homework.databinding.ActivityMainBinding
import com.example.androidproject_homework.presentation.view.auth.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
        val doesUserExists = authInteractor.checkUserExists()
        mainView.userExistsResult(doesUserExists)
    }
}