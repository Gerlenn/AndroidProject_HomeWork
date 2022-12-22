package com.example.androidproject_homework.di

import com.example.androidproject_homework.data.auth.AuthRepositoryImpl
import com.example.androidproject_homework.data.items.ItemsRepositoryImpl
import com.example.androidproject_homework.domain.auth.AuthRepository
import com.example.androidproject_homework.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}