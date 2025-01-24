package com.service.hackathon.repositories;

import com.service.hackathon.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepository {
    private final HashMap<Long, Product> productHashMap;

    private final List<Product> productList;

    public void addProducts(int count) {
        for(int i=0;i<count;i++) {
            Product product = new Product("Product "+i,i*10);
            saveProduct(product);
        }
    }

    public ProductRepository() {
        productHashMap = new HashMap<>();
        productList = new ArrayList<>();
        addProducts(5);
    }

    public void saveProduct(final Product product){
        productHashMap.put(product.getId(), product);
        productList.add(product);
    }

    public Product getProductById(final Long id) {
        return productHashMap.getOrDefault(id, null);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

}
