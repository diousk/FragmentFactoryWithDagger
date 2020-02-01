package com.diousk.fragmentfactorydaggersample.dummy

import android.util.Log
import androidx.lifecycle.ViewModel
import com.diousk.fragmentfactorydaggersample.repo.AppRepo
import javax.inject.Inject

class DummyViewModel @Inject constructor(
    private val repo: AppRepo,
    private val dummyRepo: DummyRepo
) : ViewModel() {
    fun test() {
        Log.d("DummyViewModel", "test repo $this")
        repo.hello()
        dummyRepo.dummyHello()
    }
}
