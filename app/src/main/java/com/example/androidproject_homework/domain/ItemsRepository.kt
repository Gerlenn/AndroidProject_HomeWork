package com.example.androidproject_homework.domain

import com.example.androidproject_homework.presentation.model.ItemsModel

interface ItemsRepository{

    fun getData(): List<ItemsModel>
}