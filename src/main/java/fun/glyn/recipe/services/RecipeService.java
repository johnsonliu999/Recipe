package fun.glyn.recipe.services;

import fun.glyn.recipe.commands.RecipeCommand;
import fun.glyn.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    void deleteById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long l);
}
