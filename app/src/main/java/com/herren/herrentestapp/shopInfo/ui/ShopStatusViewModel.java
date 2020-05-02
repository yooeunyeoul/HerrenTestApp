package com.herren.herrentestapp.shopInfo.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.herren.herrentestapp.shopInfo.data.ShopInfoRepository;
import com.herren.herrentestapp.shopInfo.data.ShopStatus;
import com.herren.herrentestapp.shopInfo.data.StatusList;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ShopStatusViewModel extends ViewModel {

    private final ShopInfoRepository repository;
    private CompositeDisposable disposable;

    private final MutableLiveData<List<ShopStatus>> shopStatus = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private int pageNum;

    @Inject
    ShopStatusViewModel(ShopInfoRepository repository) {

        this.repository = repository;

        disposable = new CompositeDisposable();

        fetchData(1);

    }

    LiveData<List<ShopStatus>> getShopStatus() {
        return shopStatus;
    }

    public  LiveData<Boolean> getError() {
        return loadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchData(int pageNum) {
        this.pageNum = pageNum;
        loading.setValue(true);

        disposable.add(repository.getShopStatus(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<StatusList>() {

                    @Override
                    public void onSuccess(StatusList shopStatuses) {
//                        Logger.e("onSuccess Result Data : "+shopStatuses.getStatusList().toString());
                        loadError.setValue(false);
                        Logger.e("페이지 넘버"+pageNum);
                        if (pageNum ==1 ) {
                            shopStatus.setValue(shopStatuses.getStatusList());

                        } else {

                            Logger.e("설마 여기 계쏙 안타냐?");
                            List<ShopStatus> beforeData = shopStatus.getValue();
                            beforeData.addAll(shopStatuses.getStatusList());
                            shopStatus.setValue(beforeData);
                            Logger.e(String.valueOf(beforeData.size()));
                            Logger.e("설마 여기만 타냐");
                        }
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e("onError Result Data : "+e.getMessage());
                        loadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
