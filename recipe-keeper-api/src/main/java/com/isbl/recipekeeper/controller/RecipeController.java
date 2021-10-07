package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.domain.dto.RecipeDto;
import com.isbl.recipekeeper.domain.exception.RecipeNotFoundException;
import com.isbl.recipekeeper.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service){
        this.service = service;
    }

    @GetMapping()
    List<RecipeDto> getAllRecipes() {
        return service.getAllRecipes();
    }

    @GetMapping("{id}")
    @ResponseBody
    RecipeDto getRecipeById(@PathVariable Long id) throws RecipeNotFoundException {
        return service.getRecipeById(id);
    }

    @PostMapping
    @ResponseBody
    RecipeDto addRecipe(@RequestBody RecipeDto recipe){
        return service.saveRecipe(recipe);
    }

}
