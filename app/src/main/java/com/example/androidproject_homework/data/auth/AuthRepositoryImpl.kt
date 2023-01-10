package com.example.androidproject_homework.data.auth

import com.example.androidproject_homework.data.sharedpref.SharedPreferencesHelper
import com.example.androidproject_homework.domain.auth.AuthRepository
import com.example.androidproject_homework.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
) : AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override suspend fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override suspend fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override suspend fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}