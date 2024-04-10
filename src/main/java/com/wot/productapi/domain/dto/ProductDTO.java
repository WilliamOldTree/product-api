package com.wot.productapi.domain.dto;

import com.wot.productapi.domain.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoryDTO categoryDTO;

    public static ProductDTO convertEntityToDto(Product product){

        var dto = new ProductDTO();

        dto.setProductIdentifier(dto.getProductIdentifier());
        dto.setNome(product.getNome());
        dto.setDescricao(dto.getDescricao());
        dto.setPreco(dto.getPreco());
        if (product.getCategory() != null) {
            dto.setCategoryDTO(CategoryDTO.convertEntityToDto(product.getCategory()));
        }

        return dto;

    }

}
