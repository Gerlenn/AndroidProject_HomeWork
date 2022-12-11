package com.example.androidproject_homework.presentation.adapter.listener

interface itemListener {

    fun onClick()

    fun onElementSelected(
        title: Int,
        about: Int,
        time: String,
        image: Int,
        favoriteImage: Int,
    )
}