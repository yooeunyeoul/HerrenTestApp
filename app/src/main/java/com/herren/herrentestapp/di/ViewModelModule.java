package com.herren.herrentestapp.di;

import androidx.lifecycle.ViewModel;

import com.herren.herrentestapp.shopInfo.ui.ShopStatusViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelMapKey(ShopStatusViewModel.class)
    abstract ViewModel bindShopInfoViewModel(ShopStatusViewModel viewModel);

    /**
     * Inject constructor 로 주입받음
     **/
//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


}
