package com.example.androidproject_homework.di

import com.example.androidproject_homework.domain.items.ItemsInteractor
import com.example.androidproject_homework.presentation.view.home.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    fun provideItemsPresenter(
        itemsInteractor: ItemsInteractor
    ): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }
}