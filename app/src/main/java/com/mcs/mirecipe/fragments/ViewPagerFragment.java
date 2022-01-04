package com.mcs.mirecipe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mcs.mirecipe.R;
import com.mcs.mirecipe.Recipes;
import com.mcs.mirecipe.databinding.FragmentViewpagerBinding;

public class ViewPagerFragment extends Fragment {
    private FragmentViewpagerBinding binding;
    public static final String KEY_RECIPE_INDEX = "recipe_index";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        binding = FragmentViewpagerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        CheckBoxesFragment ingredientsFragment = new IngredientFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        ingredientsFragment.setArguments(bundle);
        CheckBoxesFragment directionsFragment = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        directionsFragment.setArguments(bundle);

        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentStateAdapter(getActivity()) {
            @Override
            public int getItemCount() {
                return 2;
            }
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }
        });

        TabLayout tabLayout = binding.tabLayout;
        String[] titles = {"Ingredients", "Directions"};
        new TabLayoutMediator(tabLayout,viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText( titles[position]);
            }
        }
        ).attach();

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
