package com.example.androidproject_homework.domain

import com.example.androidproject_homework.presentation.model.ItemsModel

class ItemsInteractor(private val itemsInteractor: ItemsInteractor) {

    fun getData(): List<ItemsModel>{
        return itemsInteractor.getData()
    }
}