package com.isbl.recipekeeper.util.mapper;

import com.isbl.recipekeeper.domain.dto.RecipeDto;
import com.isbl.recipekeeper.domain.entity.Recipe;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {RecipeIngredientMapper.class, RecipeStepMapper.class})
public interface RecipeMapper {

    @Mapping(source = "source.id", target="id")
    @Mapping(source = "source.name", target="name")
    @Mapping(source = "source.steps", target="steps")
    @Mapping(source = "source.ingredients", target="ingredients")
    RecipeDto recipeToDto(Recipe source);
}
