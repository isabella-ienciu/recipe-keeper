package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.domain.Recipe;
import com.isbl.recipekeeper.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

}
