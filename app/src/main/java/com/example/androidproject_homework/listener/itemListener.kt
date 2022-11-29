package com.example.androidproject_homework.listener

interface itemListener {

    fun onClick()

    fun onElementSelected(
        name: String,
        date: String,
        imageView: String,
        image: Int,
        favoriteImage: Int
    )
}