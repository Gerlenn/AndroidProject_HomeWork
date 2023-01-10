package com.example.androidproject_homework.domain.items

import com.example.androidproject_homework.model.ItemsModel

interface ItemsRepository {

    suspend fun getData(): List<ItemsModel>
}