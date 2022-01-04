package com.mcs.mirecipe.fragments;

import com.mcs.mirecipe.Recipes;

public class IngredientFragment extends CheckBoxesFragment{

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
