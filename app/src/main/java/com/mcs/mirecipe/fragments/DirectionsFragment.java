package com.mcs.mirecipe.fragments;

import com.mcs.mirecipe.Recipes;

public class DirectionsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
