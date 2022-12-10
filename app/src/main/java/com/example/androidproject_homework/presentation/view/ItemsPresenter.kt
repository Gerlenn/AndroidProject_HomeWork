package com.example.androidproject_homework.presentation.view

import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.ItemsInteractor
import com.example.androidproject_homework.model.ItemsModel

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
    ) {

    fun getData() {
        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.click)
    }

    fun elementSelected(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        itemsView.goToDetails(title, about, time, image, favoriteImage)
    }
}