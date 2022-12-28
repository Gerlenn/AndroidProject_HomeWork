package com.example.androidproject_homework.presentation.view.home

import com.example.androidproject_homework.domain.auth.AuthInteractor
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
        authInteractor.logoutUser()
        detailsView.userLoggedOut()
    }
}