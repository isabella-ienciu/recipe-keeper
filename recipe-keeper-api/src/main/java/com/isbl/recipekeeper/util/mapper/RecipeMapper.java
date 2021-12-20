package com.isbl.recipekeeper.util.mapper;

import com.isbl.recipekeeper.domain.dto.RecipeDto;
import com.isbl.recipekeeper.domain.entity.Measurement;
import com.isbl.recipekeeper.domain.entity.Recipe;
import com.isbl.recipekeeper.repository.MeasurementRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {RecipeIngredientMapper.class, RecipeStepMapper.class})
public abstract class RecipeMapper {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Mapping(source = "source.id", target="id")
    @Mapping(source = "source.name", target="name")
    @Mapping(source = "source.steps", target="steps")
    @Mapping(source = "source.ingredients", target="ingredients")
    public abstract RecipeDto recipeToDto(Recipe source);

    @InheritInverseConfiguration
    public abstract Recipe dtoToRecipe(RecipeDto source);

    Measurement map(String value){
        Measurement correspondingMeasurement = measurementRepository.findByName(value);
        return correspondingMeasurement;
    }
}
