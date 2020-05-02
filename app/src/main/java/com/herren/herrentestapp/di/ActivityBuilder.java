package com.herren.herrentestapp.di;

import com.herren.herrentestapp.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract
class ActivityBuilder {
    @ContributesAndroidInjector(modules = {FragmentShopInfoProvider.class})
    abstract MainActivity bindMainActivity();


}