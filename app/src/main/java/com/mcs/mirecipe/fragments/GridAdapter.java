package com.mcs.mirecipe.fragments;

import com.mcs.mirecipe.R;
import com.mcs.mirecipe.adapters.RecyclerAdapter;

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }
    @Override
    protected int getLayoutID() {
        return R.layout.grid_item;
    }
    @Override
    protected void onRecipeSelected(int mIndex) {
        mListener.onGridRecipeSelected(mIndex);
    }

}
