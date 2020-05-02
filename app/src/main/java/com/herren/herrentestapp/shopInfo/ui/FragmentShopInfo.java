package com.herren.herrentestapp.shopInfo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.herren.herrentestapp.R;
import com.herren.herrentestapp.databinding.FragmentShopInfoBinding;
import com.herren.herrentestapp.shopInfo.data.ShopInfoRepository;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class FragmentShopInfo extends DaggerFragment {

    private ShopStatusViewModel viewModel;

    @Inject
    ShopInfoRepository repository;
    private ShopAdapter adapter;
    private int pageNum = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentShopInfoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_info, container, false);

        viewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ShopStatusViewModel(repository);
            }
        }).get(ShopStatusViewModel.class);

        binding.setLifecycleOwner(this);

        adapter = new ShopAdapter();

        binding.recyclerShopInfo.setAdapter(adapter);

        subscribeUi(binding);

        setRecyclerEndPosition(binding);
        return binding.getRoot();
    }

    private void setRecyclerEndPosition(FragmentShopInfoBinding binding) {
        binding.recyclerShopInfo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPosition = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).findLastCompletelyVisibleItemPosition();
                int totalCount = Objects.requireNonNull(recyclerView.getAdapter()).getItemCount()-1;


//                Logger.e(String.valueOf("라스트 포지션"+lastPosition));
//                Logger.e(String.valueOf("총 개"+totalCount));

                if (lastPosition == totalCount) {
                    pageNum = pageNum+1;
                    viewModel.fetchData(pageNum);

                }
            }
        });
    }


    private void subscribeUi(FragmentShopInfoBinding binding) {
        viewModel.getShopStatus().observe(this, shopStatuses -> {
            adapter.setItem(shopStatuses);
            adapter.notifyDataSetChanged();
        });

        viewModel.getLoading().observe(this, aBoolean -> {
            if (aBoolean) {
                binding.progress.setVisibility(View.VISIBLE);
            } else {
                binding.progress.setVisibility(View.GONE);
            }
        });


    }

}
