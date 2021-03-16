package com.isbl.recipekeeper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recipe {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
