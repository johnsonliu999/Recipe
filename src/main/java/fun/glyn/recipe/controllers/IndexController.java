package fun.glyn.recipe.controllers;

import fun.glyn.recipe.domain.Category;
import fun.glyn.recipe.domain.UnitOfMeasure;
import fun.glyn.recipe.repositories.CategoryRepository;
import fun.glyn.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat ID : " + categoryOptional.get().getId());
        System.out.println("Unit ID : " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
