package com.example.androidproject_homework.domain.items

import com.example.androidproject_homework.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}