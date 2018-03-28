package fun.glyn.recipe.services;

import fun.glyn.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
