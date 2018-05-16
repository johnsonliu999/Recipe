package fun.glyn.recipe.services;

import fun.glyn.recipe.converters.RecipeCommandToRecipe;
import fun.glyn.recipe.converters.RecipeToRecipeCommand;
import fun.glyn.recipe.exceptions.NotFoundException;
import fun.glyn.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeNotFound() {
        recipeService.findById(35L);
    }

}