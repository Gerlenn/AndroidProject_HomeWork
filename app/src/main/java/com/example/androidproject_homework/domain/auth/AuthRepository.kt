package com.example.androidproject_homework.domain.auth

import com.example.androidproject_homework.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend fun userLogout()
}