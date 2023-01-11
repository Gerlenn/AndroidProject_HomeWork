package com.example.androidproject_homework.domain.items

import com.example.androidproject_homework.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}