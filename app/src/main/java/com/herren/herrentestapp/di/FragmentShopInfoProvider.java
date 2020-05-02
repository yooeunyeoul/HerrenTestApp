package com.herren.herrentestapp.di;

import com.herren.herrentestapp.shopInfo.ui.FragmentShopInfo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentShopInfoProvider {

    @ContributesAndroidInjector
    abstract FragmentShopInfo provideShopInfoFragmentFactory();
}
