package com.example.androidproject_homework.presentation.view.home

import android.util.Log
import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.items.ItemsInteractor
import kotlinx.coroutines.*
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var  itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }

    fun getItems() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler){
            try {

                val job = launch {
                    val listItems = itemsInteractor.getData()
                    itemsView.itemsReceived(listItems)
                }
            }catch (e: Exception){
                Log.w("exception", "list items FAILED")
            }

        }
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.click)
    }

    fun itemClicked(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        itemsView.itemClicked(NavigateWithBundle(title, about, time, image, favoriteImage))
    }
}

data class NavigateWithBundle(
    val title: Int,
    val about: Int,
    val time: String,
    val image: Int,
    val favoriteImage: Int
)