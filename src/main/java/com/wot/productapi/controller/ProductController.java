package com.wot.productapi.controller;

import com.wot.productapi.domain.dto.ProductDTO;
import com.wot.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDTO> getProducts(){
        return service.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long id){
        return service.findProductByCategoryId(id);
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO getProductId(@PathVariable String productIdentifier){
        return service.findProductIdentifier(productIdentifier);
    }

    @PostMapping
    public ProductDTO newProduct(@RequestBody ProductDTO dto){
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PostMapping("/{id}")
    public ProductDTO editProduct(@PathVariable Long id,
                                  @RequestBody ProductDTO dto){
        return service.editProduct(id, dto);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getProductsPageable(Pageable pageable){
        return service.getAllPage(pageable);
    }





}
