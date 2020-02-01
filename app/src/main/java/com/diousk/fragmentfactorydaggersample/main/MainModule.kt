package com.diousk.fragmentfactorydaggersample.main

import androidx.lifecycle.ViewModel
import com.diousk.fragmentfactorydaggersample.di.FragmentBuilder
import com.diousk.fragmentfactorydaggersample.di.ViewModelBuilder
import com.diousk.fragmentfactorydaggersample.di.annotation.ViewModelKey
import com.diousk.fragmentfactorydaggersample.dummy.DummyBuilder
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainBuilder {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class,
        FragmentBuilder::class,
        MainModule::class,
        DummyBuilder::class
    ])
    abstract fun bindMainActivity(): MainActivity
}

@Module
abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(vm: MainViewModel): ViewModel
}