package com.isbl.recipekeeper.repository;

import com.isbl.recipekeeper.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
