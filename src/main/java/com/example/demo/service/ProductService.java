package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRep pr;

    ProductService(ProductRep pr) {
        this.pr = pr;
    }

    public Product createProduct(Product product) {
        return pr.save(product);
    }

    public List<Product> getALLProduct() {
        return pr.findAll();
    }

    public Product getProductById(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setStock(product.getStock());
        return pr.save(existing);
    }

    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        pr.delete(existing);
    }
}