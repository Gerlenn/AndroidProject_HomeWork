package com.example.androidproject_homework

interface itemListener {

    fun onClick()

    fun onElementSelected(
        name: Int,
        about: Int,
        time: String,
        image: Int,
        favoriteImage: Int,
    )
}