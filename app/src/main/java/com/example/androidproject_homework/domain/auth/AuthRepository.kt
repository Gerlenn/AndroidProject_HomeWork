package com.example.androidproject_homework.domain.auth

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)
}