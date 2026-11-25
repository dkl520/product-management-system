package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService ps;

    ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/all")
    List<Product> getAllProduct() {
        return ps.getALLProduct();
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(ps.getProductById(id));
    }

    @PostMapping("/create")
    ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = ps.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = ps.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        ps.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}