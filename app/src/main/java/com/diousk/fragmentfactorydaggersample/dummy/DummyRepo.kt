package com.diousk.fragmentfactorydaggersample.dummy

import android.util.Log
import javax.inject.Inject

class DummyRepo @Inject constructor() {
    fun dummyHello() {
        Log.d("DUMMY_REPO", "dummyHello")
    }
}