package com.food.dumplingdelights.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Data
@Table(name = "category")
public class Category {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cat_name")
    @NotNull
    @NotEmpty
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> books = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;

        return id == category.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
