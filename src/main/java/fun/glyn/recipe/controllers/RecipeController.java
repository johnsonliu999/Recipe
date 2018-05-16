package fun.glyn.recipe.controllers;

import fun.glyn.recipe.commands.RecipeCommand;
import fun.glyn.recipe.converters.RecipeToRecipeCommand;
import fun.glyn.recipe.exceptions.NotFoundException;
import fun.glyn.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/form";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors().toString());
            return "recipe/form";
        }

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        return "recipe/form";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        log.debug("Delete id :" + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errors/404");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errors/400");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }


}
