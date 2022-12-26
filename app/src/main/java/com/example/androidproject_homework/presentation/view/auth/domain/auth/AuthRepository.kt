package com.example.androidproject_homework.presentation.view.auth.domain.auth

import com.example.androidproject_homework.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()
}