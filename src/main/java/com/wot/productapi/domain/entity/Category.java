package com.wot.productapi.domain.entity;

import com.wot.productapi.domain.dto.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    public static Category convertDtoToEntity(CategoryDTO categoryDTO) {

        var category = new Category();

        category.setId(categoryDTO.getId());
        category.setNome(categoryDTO.getNome());

        return category;
    }
}
