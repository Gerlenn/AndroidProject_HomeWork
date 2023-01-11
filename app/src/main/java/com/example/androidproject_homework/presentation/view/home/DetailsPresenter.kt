package com.example.androidproject_homework.presentation.view.home

import android.util.Log
import com.example.androidproject_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor,
) {

    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        detailsView = detailsFragment
    }

    fun getArguments(title: Int, about: Int, time: String?, image: Int, favoriteImage: Int) {
        detailsView.displayItemData(title, about,
            when (time.isNullOrEmpty()) {
                true -> "no data"
                false -> time
            },
            image,
            favoriteImage
        )
    }

    fun logoutUser() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    detailsView.userLoggedOut()
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "logout user FAILED")
            }
        }
    }
}