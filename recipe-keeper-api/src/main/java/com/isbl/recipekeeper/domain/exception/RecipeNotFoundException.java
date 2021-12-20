package com.isbl.recipekeeper.domain.exception;

public class RecipeNotFoundException extends Exception{
    public RecipeNotFoundException(Long id){
        super(String.format("Recipe for id %d not found in database",id));
    }
}
