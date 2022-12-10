package com.example.androidproject_homework.domain

import com.example.androidproject_homework.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}