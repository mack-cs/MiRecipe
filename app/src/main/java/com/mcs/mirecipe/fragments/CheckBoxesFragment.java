package com.mcs.mirecipe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mcs.mirecipe.Recipes;
import com.mcs.mirecipe.databinding.FragmentCheckboxesBinding;

public abstract class CheckBoxesFragment extends Fragment {
    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    private FragmentCheckboxesBinding binding;
    private CheckBox[] mCheckBoxes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        binding = FragmentCheckboxesBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        String[] contents = getContents(index);
        LinearLayout linearLayout = binding.checkBoxesLayout;
        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        setUpCheckBoxes(linearLayout, contents,checkedBoxes);
        return view;
    }

    public abstract String[] getContents(int index);

    private void setUpCheckBoxes(ViewGroup linearLayout, String[] contents, boolean[] checkBoxes) {
        int i = 0;
        for (String content: contents){
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8,16, 8, 16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(content);
            linearLayout.addView(mCheckBoxes[i]);
            if (checkBoxes[i]){
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
       boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
       int i = 0;
       for (CheckBox checkBox : mCheckBoxes){
           stateOfCheckBoxes[i] = checkBox.isChecked();
           i++;
       }
       outState.putBooleanArray(KEY_CHECKED_BOXES,stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
