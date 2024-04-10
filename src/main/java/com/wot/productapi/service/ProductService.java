package com.wot.productapi.service;

import com.wot.productapi.domain.dto.ProductDTO;
import com.wot.productapi.domain.entity.Product;
import com.wot.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductDTO> getAll(){
        List<Product> products = repository.findAll();
        return products
                .stream()
                .map(ProductDTO::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> findProductByCategoryId(Long categoryId){
        List<Product> productsById = repository.getProductsByCategory(categoryId);
        return productsById
                .stream()
                .map(ProductDTO::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO findProductIdentifier(String productIdentifier){

        Product product = repository.findByProductIdentifier(productIdentifier);
        if( product != null) {
            return ProductDTO.convertEntityToDto(product);
        }
            return null;
    }

    public ProductDTO save(ProductDTO dto){
        Product product = repository.save(Product.convertDtoToEntity(dto));
        return ProductDTO.convertEntityToDto(product);
    }

    public ProductDTO delete (Long id){
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()){
            repository.delete(product.get());
        }
        return null;
    }

    public ProductDTO editProduct (Long id, ProductDTO dto){

        Product product = repository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));

        if(dto.getNome() != null || dto.getNome().isEmpty()){
            product.setNome(dto.getNome());
        }

        if(dto.getPreco() != null){
            product.setPreco(dto.getPreco());
        }

        return ProductDTO.convertEntityToDto(repository.save(product));

    }

    public Page<ProductDTO> getAllPage(Pageable pageable){
        Page<Product> users = repository.findAll(pageable);
        return users
                .map(ProductDTO::convertEntityToDto);
    }


}
