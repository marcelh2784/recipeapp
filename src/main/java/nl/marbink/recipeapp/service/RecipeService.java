package nl.marbink.recipeapp.service;

import nl.marbink.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
