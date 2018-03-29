package fun.glyn.recipe.services;

import fun.glyn.recipe.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteByRecipeIdAndId(Long recipeId, Long id);
}
