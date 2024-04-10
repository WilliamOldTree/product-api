package com.wot.productapi.domain.dto;

import com.wot.productapi.domain.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;

    public static CategoryDTO convertEntityToDto(Category category) {

        var dto = new CategoryDTO();

        dto.setId(category.getId());
        dto.setNome(category.getNome());

        return dto;

    }
}
