package com.example.androidproject_homework.domain.auth

import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository) {

    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }
}