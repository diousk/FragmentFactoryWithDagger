package com.diousk.fragmentfactorydaggersample.di

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentBuilder {
    @Binds
    abstract fun bindFragmentFactory(
        factory: DaggerFragmentFactory
    ): FragmentFactory
}