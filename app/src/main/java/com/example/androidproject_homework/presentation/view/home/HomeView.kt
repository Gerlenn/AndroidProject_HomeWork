package com.example.androidproject_homework.presentation.view.home

import com.example.androidproject_homework.model.UserModel

interface HomeView {

    fun showUserCreds(login: UserModel)

    fun goToOnBoarding()

}