package com.example.androidproject_homework.presentation.view.home

interface DetailsView {

    fun userLoggedOut()

    fun displayItemData(title: Int, about: Int, time: String, image: Int, favoriteImage: Int)
}