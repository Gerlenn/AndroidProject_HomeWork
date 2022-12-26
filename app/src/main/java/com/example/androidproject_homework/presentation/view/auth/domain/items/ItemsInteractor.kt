package com.example.androidproject_homework.presentation.view.auth.domain.items

import com.example.androidproject_homework.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}