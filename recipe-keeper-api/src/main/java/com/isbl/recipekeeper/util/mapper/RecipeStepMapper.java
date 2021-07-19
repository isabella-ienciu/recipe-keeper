package com.isbl.recipekeeper.util.mapper;

import com.isbl.recipekeeper.domain.dto.RecipeStepDto;
import com.isbl.recipekeeper.domain.entity.RecipeStep;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface RecipeStepMapper {
    RecipeStepDto mapRecipeStepToDto(RecipeStep source);
}
