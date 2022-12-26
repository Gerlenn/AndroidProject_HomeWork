package com.example.androidproject_homework.presentation.view.auth.domain.auth

import com.example.androidproject_homework.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val  authRepository: AuthRepository) {

    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUserExists(): Boolean{
        return authRepository.doesUserExist()
    }

    fun logoutUser(){
        authRepository.userLogout()
    }
}