package com.example.androidproject_homework.di

import com.example.androidproject_homework.presentation.view.auth.domain.auth.AuthInteractor
import com.example.androidproject_homework.presentation.view.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter {
        return MainPresenter(authInteractor)
    }
}