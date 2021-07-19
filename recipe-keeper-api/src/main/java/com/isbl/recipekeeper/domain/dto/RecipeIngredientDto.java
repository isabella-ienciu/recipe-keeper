package com.isbl.recipekeeper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeIngredientDto {
    private String name;
    private String measurement;
    private Integer quantity;
}
