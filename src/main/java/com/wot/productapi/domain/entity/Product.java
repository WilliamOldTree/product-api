package com.wot.productapi.domain.entity;

import com.wot.productapi.domain.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convertDtoToEntity(ProductDTO dto){

        var product = new Product();

        product.setNome(dto.getNome());
        product.setPreco(dto.getPreco());
        product.setDescricao(dto.getDescricao());
        product.setProductIdentifier(dto.getProductIdentifier());
        if(dto.getCategoryDTO() != null){
            product.setCategory(Category.convertDtoToEntity(dto.getCategoryDTO()));
        }
        return product;
    }


}
