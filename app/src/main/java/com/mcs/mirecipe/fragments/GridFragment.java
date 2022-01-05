package com.mcs.mirecipe.fragments;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcs.mirecipe.adapters.ListAdapter;
import com.mcs.mirecipe.databinding.FragmentRecyclerviewBinding;

public class GridFragment extends Fragment {
    public interface OnRecipeSelectedInterface{
        void onGridRecipeSelected(int index);
    }
    private FragmentRecyclerviewBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GridFragment.OnRecipeSelectedInterface listener = (GridFragment.OnRecipeSelectedInterface)getActivity();
        binding = FragmentRecyclerviewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        GridAdapter gridAdapter = new GridAdapter(listener);
        binding.recyclerView.setAdapter(gridAdapter);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int) (dpWidth/200);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        binding.recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
