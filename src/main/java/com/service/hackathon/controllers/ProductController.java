package com.service.hackathon.controllers;

import com.service.hackathon.dtos.RequestDto;
import com.service.hackathon.models.Product;
import com.service.hackathon.repositories.ProductRepository;
import com.service.hackathon.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody final RequestDto requestDto) {
        final String productName = requestDto.getProductName();
        final double price = requestDto.getPrice();
        final Product savedProduct = productService.saveProduct(productName, price);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> getProduct(@RequestBody final RequestDto requestDto) {
        final long productId = requestDto.getProductId();
        final Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productRepository.getAllProducts(), HttpStatus.OK);
    }
}
