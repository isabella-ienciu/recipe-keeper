package com.isbl.recipekeeper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    //private @Id @GeneratedValue Long id;
    private Long id;
    private String name;
}
