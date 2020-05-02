package com.herren.herrentestapp.shopInfo.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.herren.herrentestapp.databinding.ListItemShopStatusBinding;
import com.herren.herrentestapp.shopInfo.data.ShopStatus;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.CustomViewHolder> {

    private List<ShopStatus> mList;

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private final ListItemShopStatusBinding binding;

        CustomViewHolder(ListItemShopStatusBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(ShopStatus item) {

            binding.setShopStatus(item);

        }
    }


    public void setItem(List<ShopStatus> list) {

        if (list != null) {
            if (mList == null) {
                mList = new ArrayList<>();
            }
            this.mList.addAll(list);
        }
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new CustomViewHolder(ListItemShopStatusBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ShopStatus shopStatus = mList.get(position);
        holder.bind(shopStatus);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
