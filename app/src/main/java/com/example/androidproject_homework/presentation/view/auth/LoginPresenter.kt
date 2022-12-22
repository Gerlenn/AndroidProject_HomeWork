package com.example.androidproject_homework.presentation.view.auth

import com.example.androidproject_homework.domain.auth.AuthInteractor
import com.example.androidproject_homework.presentation.view.home.LoginView
import javax.inject.Inject

class LoginPresenter @Inject constructor (private val authInteractor: AuthInteractor){

    private lateinit var  loginView: LoginView

    fun loginUser(userName: String, userPassword: String){
        loginView.loginUser(userName, userPassword)

    }
}