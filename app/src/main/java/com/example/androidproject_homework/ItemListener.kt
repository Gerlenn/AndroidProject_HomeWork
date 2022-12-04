package com.example.androidproject_homework

interface itemListener {

    fun onClick()

    fun onElementSelected(
        name: String,
        about: String,
        time: String,
        image: Int,
        favoriteImage: Int,
    )
}