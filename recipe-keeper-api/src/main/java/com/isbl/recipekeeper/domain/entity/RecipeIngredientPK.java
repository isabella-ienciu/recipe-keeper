package com.isbl.recipekeeper.domain.entity;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class RecipeIngredientPK implements Serializable {

    private Ingredient ingredient;
    private Recipe recipe;
}
