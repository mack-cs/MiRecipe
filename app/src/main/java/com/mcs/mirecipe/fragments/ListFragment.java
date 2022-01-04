package com.mcs.mirecipe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcs.mirecipe.adapters.ListAdapter;
import com.mcs.mirecipe.databinding.FragmentListBinding;

public class ListFragment extends Fragment {
    public interface OnRecipeSelectedInterface{
        void onListRecipeSelected(int index);
    }
    private FragmentListBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface)getActivity();
        binding = FragmentListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ListAdapter listAdapter = new ListAdapter(listener);
        binding.listRecyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.listRecyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
