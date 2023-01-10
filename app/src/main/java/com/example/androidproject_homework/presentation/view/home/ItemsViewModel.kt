package com.example.androidproject_homework.presentation.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject_homework.R
import com.example.androidproject_homework.domain.items.ItemsInteractor
import com.example.androidproject_homework.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        viewModelScope.launch {
            try {
                val listItems = itemsInteractor.getData()
                _items.value = listItems
            }catch (e: Exception){
                Log.w("exception", "no data available")
            }
        }
    }

    fun imageViewClicked() {
        _msg.value = R.string.click
    }

    fun elementClicked(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        _bundle.value = NavigateWithBundle(
            title = title,
            about = about,
            time = time,
            image = image,
            favoriteImage = favoriteImage
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val title: Int,
    val about: Int,
    val time: String,
    val image: Int,
    val favoriteImage: Int,
)