package com.isbl.recipekeeper.service;

import com.isbl.recipekeeper.domain.dto.RecipeDto;
import com.isbl.recipekeeper.domain.entity.Recipe;
import com.isbl.recipekeeper.domain.exception.RecipeNotFoundException;
import com.isbl.recipekeeper.repository.RecipeRepository;
import com.isbl.recipekeeper.util.mapper.RecipeMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeMapper mapper;
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository, RecipeMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RecipeDto> getAllRecipes() {
        var recipes = repository.findAll();
        var recipeDtos = new ArrayList<RecipeDto>();
        for(Recipe recipe : recipes){
            recipeDtos.add(mapper.recipeToDto(recipe));
        }
        return recipeDtos;
    }

    public RecipeDto getRecipeById(Long id) throws RecipeNotFoundException {
        var recipe = repository.findById(id);
        if(recipe.isPresent()){
            return mapper.recipeToDto(recipe.get());
        } else {
            throw new RecipeNotFoundException(id);
        }
    }
}
