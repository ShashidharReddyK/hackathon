package com.service.hackathon.services;

import com.service.hackathon.models.Availability;
import com.service.hackathon.models.Product;
import com.service.hackathon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(final String productName, final double price) {
        final Product product = new Product(productName, price);
        productRepository.saveProduct(product);
        return product;
    }

    public Product getProduct(final Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Availability updateAvailability(final Long id, final Availability availability ){
        Product product = productRepository.getProductById(id);
        product.setAvailability(availability);
        return availability;
    }
}
