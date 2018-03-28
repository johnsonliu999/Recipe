package fun.glyn.recipe.bootstrap;

import fun.glyn.recipe.domain.Ingredient;
import fun.glyn.recipe.domain.Recipe;
import fun.glyn.recipe.domain.UnitOfMeasure;
import fun.glyn.recipe.repositories.RecipeRepository;
import fun.glyn.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DevBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Recipe guacRecip = new Recipe();
        Ingredient powderIng = new Ingredient();
        powderIng.setAmount(BigDecimal.valueOf(2));
        powderIng.setDescription("2 tablespoons ancho chili powder");


    }
}
