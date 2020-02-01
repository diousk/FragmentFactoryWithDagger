package com.diousk.fragmentfactorydaggersample

import com.diousk.fragmentfactorydaggersample.di.AppComponent
import com.diousk.fragmentfactorydaggersample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}