package com.example.androidproject_homework.presentation.view.home

import com.example.androidproject_homework.model.ItemsModel

interface ItemsView {

    fun itemsReceived(itemsList: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun itemClicked(navigationData: NavigateWithBundle)

}