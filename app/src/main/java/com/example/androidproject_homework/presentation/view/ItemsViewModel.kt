package com.example.androidproject_homework.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.ItemsInteractor
import com.example.androidproject_homework.presentation.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemsViewModel(private val itemsInteractor: ItemsInteractor): ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData(){
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }

    fun imageViewClicked(){
        _msg.value = R.string.click
    }

    fun elementClicked(title: Int, about: Int, time: String, image: Int, favoriteImage: Int){
        _bundle.value = NavigateWithBundle(
            title = title,
            about = about,
            time = time,
            image = image,
            favoriteImage = favoriteImage
        )
    }

    fun userNavigated(){
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val title: Int,
    val about: Int,
    val time: String,
    val image: Int,
    val favoriteImage: Int
)