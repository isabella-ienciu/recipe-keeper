package com.isbl.recipekeeper.repository;

import com.isbl.recipekeeper.domain.entity.Ingredient;
import com.isbl.recipekeeper.domain.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Measurement findByName(String name);
}
