package com.haratres.service;

import com.haratres.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product getProductById(Long id);

    void saveProduct(Product product);

    void deleteProductById(Long id);

}
