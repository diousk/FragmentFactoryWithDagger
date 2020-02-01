package com.diousk.fragmentfactorydaggersample.dummy

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.diousk.fragmentfactorydaggersample.di.annotation.FragmentKey
import com.diousk.fragmentfactorydaggersample.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DummyBuilder {
    @ContributesAndroidInjector(modules = [DummyModule::class])
    abstract fun bindDummygFragment(): DummyFragment

    // put binding of fragment at this layer(not DummyModule) for parent to inject
    @Binds
    @IntoMap
    @FragmentKey(DummyFragment::class)
    abstract fun bindDummyFragment(fragment: DummyFragment): Fragment
}

@Module
abstract class DummyModule {
    @Binds
    @IntoMap
    @ViewModelKey(DummyViewModel::class)
    abstract fun bindDummyViewModel(viewModel: DummyViewModel): ViewModel
}