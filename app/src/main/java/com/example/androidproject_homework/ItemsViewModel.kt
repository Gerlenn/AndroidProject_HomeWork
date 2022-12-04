package com.example.androidproject_homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_homework.AppConstants.Companion.MSG
import com.example.androidproject_homework.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemsViewModel : ViewModel() {
    val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

    fun getData(){
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
        _items.value = listItems
    }

    fun imageViewClicked(){
        _msg.value = MSG
    }

    fun elementClicked(name: Int, about: Int, time: String, image: Int, favoriteImage: Int){
        _bundle.value = NavigateWithBundle(
            name = name,
            about = about,
            time = time,
            image = image,
            favoriteImage = favoriteImage
        )
    }
}

data class NavigateWithBundle(
    val name: Int,
    val about: Int,
    val time: String,
    val image: Int,
    val favoriteImage: Int
)