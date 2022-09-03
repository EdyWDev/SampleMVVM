package com.example.mymvvmsample.di

import com.example.mymvvmsample.service.CatFactRepository
import com.example.mymvvmsample.service.CatFactService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatFactRepository(
        catFactService: CatFactService
    ): CatFactRepository =
        CatFactRepository(catFactService)
}