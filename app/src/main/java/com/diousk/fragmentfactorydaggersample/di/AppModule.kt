package com.diousk.fragmentfactorydaggersample.di

import com.diousk.fragmentfactorydaggersample.repo.AppRepo
import com.diousk.fragmentfactorydaggersample.repo.AppRepoImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    internal abstract fun bindRepo(
        repo: AppRepoImpl
    ): AppRepo
}