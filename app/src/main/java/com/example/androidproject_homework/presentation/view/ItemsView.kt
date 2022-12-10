package com.example.androidproject_homework.presentation.view

import com.example.androidproject_homework.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(title: Int, about: Int, time: String, image: Int, favoriteImage: Int)

}