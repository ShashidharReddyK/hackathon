package com.service.hackathon.controllers;

import com.service.hackathon.dtos.RequestDto;
import com.service.hackathon.models.Order;
import com.service.hackathon.models.Product;
import com.service.hackathon.models.User;
import com.service.hackathon.services.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody final RequestDto requestDto) {
        final List<Product> productList = requestDto.getProductList();
        final long userId = requestDto.getUserId();
        final Order order = orderService.saveOrder(productList, userId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<Order> getOrder(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }
}
