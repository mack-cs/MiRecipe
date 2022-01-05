package com.mcs.mirecipe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.mcs.mirecipe.R;
import com.mcs.mirecipe.Recipes;
import com.mcs.mirecipe.databinding.FragmentDualpaneBinding;
import com.mcs.mirecipe.databinding.FragmentViewpagerBinding;

public class FragmentDualPane extends Fragment {
    private static final String INGREDIENT_FRAGMENT = "ingredient_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";
    private FragmentDualpaneBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        binding = FragmentDualpaneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        FragmentManager fragmentManager = getChildFragmentManager();
        IngredientFragment savedIngredientFragment = (IngredientFragment) fragmentManager.findFragmentByTag(INGREDIENT_FRAGMENT);

        if (savedIngredientFragment == null){
            IngredientFragment ingredientsFragment = new IngredientFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
            .add(R.id.leftPlaceholder,ingredientsFragment,INGREDIENT_FRAGMENT)
            .commit();

        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT);

        if (savedDirectionsFragment == null){
            DirectionsFragment directionsFragment = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
            directionsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder,directionsFragment,DIRECTIONS_FRAGMENT)
                    .commit();

        }

        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
