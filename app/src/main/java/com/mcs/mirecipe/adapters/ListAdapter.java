package com.mcs.mirecipe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcs.mirecipe.fragments.ListFragment;
import com.mcs.mirecipe.Recipes;
import com.mcs.mirecipe.databinding.ListItemBinding;

public class ListAdapter extends RecyclerView.Adapter{
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView mItemTV;
        private final ImageView mItemIV;
        private int mIndex;
        public ListViewHolder(@NonNull ListItemBinding itemView) {
            super(itemView.getRoot());
            mItemTV = itemView.itemText;
            mItemIV = itemView.itemImage;
            itemView.getRoot().setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex = position;
            mItemTV.setText(Recipes.names[position]);
            mItemIV.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View view) {
            mListener.onListRecipeSelected(mIndex);
        }
    }
}

