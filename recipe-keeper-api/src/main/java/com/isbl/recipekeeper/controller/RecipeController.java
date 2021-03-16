package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.domain.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @GetMapping("/recipes")
    List<Recipe> all() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe((long) 23,"paine"));
        return recipes;
    }

}
