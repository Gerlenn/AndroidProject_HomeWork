package com.example.androidproject_homework.presentation.view.home

import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.items.ItemsInteractor
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var  itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }

    fun getItems() {
        val listItems = itemsInteractor.getData()
        itemsView.itemsReceived(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.click)
    }

    fun itemClicked(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        itemsView.itemClicked(NavigateWithBundle(title, about, time, image, favoriteImage))
    }
}

data class NavigateWithBundle(
    val title: Int,
    val about: Int,
    val time: String,
    val image: Int,
    val favoriteImage: Int
)