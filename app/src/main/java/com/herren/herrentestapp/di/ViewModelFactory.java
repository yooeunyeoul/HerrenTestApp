package com.herren.herrentestapp.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;
import java.util.Objects;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory {

//    @Inject
    private Map<Class<T>, Provider<ViewModel>> creators;

    public ViewModelFactory(Map<Class<T>, Provider<ViewModel>> creators) {
        this.creators = creators;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) Objects.requireNonNull(creators.get(modelClass));

    }
}
