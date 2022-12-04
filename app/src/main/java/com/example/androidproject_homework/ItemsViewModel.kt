package com.example.androidproject_homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
                "Harry Potter\nand the Philosopher’s Stone",
                "book №1",
                time
            ),
            ItemsModel(
                R.drawable.b,
                R.drawable.ic_star,
                "Harry Potter\nand the Chamber of Secrets",
                "book №2",
                time
            ),
            ItemsModel(
                R.drawable.c,
                R.drawable.ic_star,
                "Harry Potter\nand the Prisoner of Azkaban",
                "book №3",
                time
            ),
            ItemsModel(
                R.drawable.d,
                R.drawable.ic_star,
                "Harry Potter\nand the Goblet of Fire",
                "book №4",
                time
            ),
            ItemsModel(
                R.drawable.e,
                R.drawable.ic_star,
                "Harry Potter\nand the Order of the Phoenix",
                "book №5",
                time
            ),
            ItemsModel(
                R.drawable.f,
                R.drawable.ic_star,
                "Harry Potter\nand the Half-Blood Prince",
                "book №6",
                time
            ),
            ItemsModel(
                R.drawable.i,
                R.drawable.ic_star,
                "Harry Potter\nand the Deathly Hallows ",
                "book №7",
                time
            )
        )
        _items.value = listItems
    }

    fun imageViewClicked(){
        _msg.value = "Avada kedavra!"
    }

    fun elementClicked(name: String, about: String, time: String, image: Int, favoriteImage: Int){
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
    val name: String,
    val about: String,
    val time: String,
    val image: Int,
    val favoriteImage: Int
)