package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.domain.dto.RecipeDto;
import com.isbl.recipekeeper.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service){
        this.service = service;
    }

    @GetMapping("/recipes")
    List<RecipeDto> getAllRecipes() {
        return service.getAllRecipes();
    }

}
