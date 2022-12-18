package com.example.androidproject_homework.domain

import com.example.androidproject_homework.model.ItemsModel
import com.example.androidproject_homework.presentation.view.ItemsView
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}