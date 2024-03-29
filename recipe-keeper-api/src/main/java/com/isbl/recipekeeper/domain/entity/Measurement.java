package com.isbl.recipekeeper.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "measurements")
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Measurement {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
