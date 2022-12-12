package com.example.androidproject_homework.domain

import com.example.androidproject_homework.presentation.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}