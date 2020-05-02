package com.herren.herrentestapp.di;

import androidx.lifecycle.ViewModel;

import dagger.MapKey;

@MapKey
public @interface ViewModelMapKey {
    Class<? extends ViewModel> value();
}
