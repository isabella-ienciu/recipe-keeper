package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.domain.entity.Ingredient;
import com.isbl.recipekeeper.repository.IngredientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    private IngredientRepository repository;

    public IngredientController(IngredientRepository repository){
        this.repository = repository;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAll(){
        return repository.findAll();
    }
}
