package com.diousk.fragmentfactorydaggersample.repo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface AppRepo {
    fun hello()
}

@Singleton
class AppRepoImpl @Inject constructor() : AppRepo {
    override fun hello() {
        Log.d("REPO", "HELLO $this")
    }
}