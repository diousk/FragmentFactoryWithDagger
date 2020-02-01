package com.diousk.fragmentfactorydaggersample.di;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.internal.Beta;

@Beta
public abstract class FragmentInjectActivity extends AppCompatActivity
        implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        beforeOnCreate();
        super.onCreate(savedInstanceState);
    }

    protected abstract void beforeOnCreate();

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}
