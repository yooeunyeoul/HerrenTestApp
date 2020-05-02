package com.herren.herrentestapp.di;

import com.herren.herrentestapp.api.ApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {CoreDataModule.class, ViewModelModule.class})
class AppModule {

    @Provides
    ApiService provideApiService(OkHttpClient okHttpClient, GsonConverterFactory converterFactory) {
        return provideService(okHttpClient, converterFactory);
    }

    private ApiService provideService(OkHttpClient okHttpClient, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

//    @Singleton
//    @Provides
//    ShopInfoDataSource provideShopStatusRemoteDataSource(ApiService service){
//        return new ShopInfoDataSource(service);
//    }


}



