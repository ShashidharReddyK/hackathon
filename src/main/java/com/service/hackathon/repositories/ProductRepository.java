package com.service.hackathon.repositories;

import com.service.hackathon.models.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {
    private HashMap<Long, Product> productHashMap;

    public ProductRepository() {
        productHashMap = new HashMap<>();
    }

    public void saveProduct(final Product product){
        productHashMap.put(product.getId(), product);
    }

    public Product getProductById(final Long id) {
        return productHashMap.getOrDefault(id, null);

    }

}
