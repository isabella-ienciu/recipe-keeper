package com.isbl.recipekeeper.repository;

import com.isbl.recipekeeper.domain.entity.Ingredient;
import com.isbl.recipekeeper.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
