package com.service.hackathon.services;

import com.service.hackathon.models.Availability;
import com.service.hackathon.models.Product;
import com.service.hackathon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(final String productName, final double price) {
        final Product product = new Product(productName, price);
        productRepository.saveProduct(product);
    }

    public Product getProduct(final Long id) {
        return productRepository.getProductById(id);
    }

    public void updateAvailability(final Long id, final Availability availability ){
        Product product = productRepository.getProductById(id);
        product.setAvailability(availability);
    }
}
