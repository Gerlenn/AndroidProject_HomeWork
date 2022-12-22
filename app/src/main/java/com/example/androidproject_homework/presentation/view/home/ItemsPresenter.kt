package com.example.androidproject_homework.presentation.view.home

import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.items.ItemsInteractor
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var  itemsView: ItemsView

    fun setView(context: ItemsView){
        itemsView = context
    }

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