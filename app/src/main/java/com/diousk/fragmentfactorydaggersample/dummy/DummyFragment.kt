package com.diousk.fragmentfactorydaggersample.dummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.diousk.fragmentfactorydaggersample.R
import com.diousk.fragmentfactorydaggersample.repo.AppRepo
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DummyFragment @Inject constructor(
    private val repo: AppRepo
) : DaggerFragment() {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DummyViewModel> { vmFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dummy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repo.hello()
        viewModel.test()
    }
}