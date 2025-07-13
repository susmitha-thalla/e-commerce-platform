package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
            .map(existing -> {
                existing.setName(product.getName());
                existing.setDescription(product.getDescription());
                existing.setPrice(product.getPrice());
                existing.setStock(product.getStock());
                return productRepository.save(existing);
            }).orElseThrow();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

