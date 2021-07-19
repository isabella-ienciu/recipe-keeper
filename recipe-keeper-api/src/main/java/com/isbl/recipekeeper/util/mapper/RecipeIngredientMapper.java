package com.isbl.recipekeeper.util.mapper;

import com.isbl.recipekeeper.domain.dto.RecipeIngredientDto;
import com.isbl.recipekeeper.domain.entity.Ingredient;
import com.isbl.recipekeeper.domain.entity.Measurement;
import com.isbl.recipekeeper.domain.entity.RecipeIngredient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface RecipeIngredientMapper {
    @Mapping(source = "source.ingredient", target = "name")
    RecipeIngredientDto recipeIngredientToDto(RecipeIngredient source);

    default String map(Ingredient value){
        return value == null ? null : value.getName();
    }

    default String map(Measurement value){
        return value == null ? null : value.getName();
    }
}
