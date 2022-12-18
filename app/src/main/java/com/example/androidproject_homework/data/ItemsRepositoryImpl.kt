package com.example.androidproject_homework.data

import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.ItemsRepository
import com.example.androidproject_homework.model.ItemsModel
import com.example.androidproject_homework.presentation.view.time
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(): ItemsRepository{

    override fun getData(): List<ItemsModel> {
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.a,
                R.drawable.ic_star,
                R.string.title1,
                R.string.about_book1,
                time
            ),
            ItemsModel(
                R.drawable.b,
                R.drawable.ic_star,
                R.string.title2,
                R.string.about_book2,
                time
            ),
            ItemsModel(
                R.drawable.c,
                R.drawable.ic_star,
                R.string.title3,
                R.string.about_book3,
                time
            ),
            ItemsModel(
                R.drawable.d,
                R.drawable.ic_star,
                R.string.title4,
                R.string.about_book4,
                time
            ),
            ItemsModel(
                R.drawable.e,
                R.drawable.ic_star,
                R.string.title5,
                R.string.about_book5,
                time
            ),
            ItemsModel(
                R.drawable.f,
                R.drawable.ic_star,
                R.string.title6,
                R.string.about_book6,
                time
            ),
            ItemsModel(
                R.drawable.i,
                R.drawable.ic_star,
                R.string.title7,
                R.string.about_book7,
                time
            )
        )
        return listItems
    }

}