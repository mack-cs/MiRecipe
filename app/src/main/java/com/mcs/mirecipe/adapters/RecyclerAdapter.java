package com.mcs.mirecipe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcs.mirecipe.R;
import com.mcs.mirecipe.Recipes;
import com.mcs.mirecipe.databinding.ListItemBinding;
import com.mcs.mirecipe.fragments.ListFragment;

public abstract class RecyclerAdapter extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutID(),parent,false);
        return new ListViewHolder(view);
    }

    protected abstract int getLayoutID();

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
        public ListViewHolder(View itemView) {
            super(itemView);
            mItemTV = itemView.findViewById(R.id.itemText);
            mItemIV = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex = position;
            mItemTV.setText(Recipes.names[position]);
            mItemIV.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View view) {
            onRecipeSelected(mIndex);
        }
    }

    protected abstract void onRecipeSelected(int mIndex);
}

