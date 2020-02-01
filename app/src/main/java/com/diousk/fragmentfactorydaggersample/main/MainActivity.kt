package com.diousk.fragmentfactorydaggersample.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.add
import androidx.lifecycle.ViewModelProvider
import com.diousk.fragmentfactorydaggersample.R
import com.diousk.fragmentfactorydaggersample.di.FragmentInjectActivity
import com.diousk.fragmentfactorydaggersample.dummy.DummyFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : FragmentInjectActivity() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { vmFactory }

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    override fun beforeOnCreate() {
        supportFragmentManager.fragmentFactory = fragmentFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateThenAdd.setOnClickListener {
            // option1: create fragment then add to container
            val fragment = supportFragmentManager.fragmentFactory
                .instantiate(classLoader, DummyFragment::class.java.name)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment, "DUMMY")
                .commit()
        }

        directlyAdd.setOnClickListener {
            // option2: declare fragment class and add to container
            supportFragmentManager.beginTransaction()
                .add<DummyFragment>(R.id.fragmentContainer)
                .commitAllowingStateLoss()
        }
    }
}
