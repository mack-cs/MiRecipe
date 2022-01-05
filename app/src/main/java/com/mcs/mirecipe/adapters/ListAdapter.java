package com.mcs.mirecipe.adapters;

import com.mcs.mirecipe.R;
import com.mcs.mirecipe.fragments.ListFragment;

public class ListAdapter extends RecyclerAdapter{
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }
    @Override
    protected int getLayoutID() {
        return R.layout.list_item;
    }
    @Override
    protected void onRecipeSelected(int mIndex) {
        mListener.onListRecipeSelected(mIndex);
    }

}

