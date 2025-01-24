package com.service.hackathon.repositories;

import com.service.hackathon.models.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderRepository {
    private HashMap<Long, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }


    public void saveOrder(final Order order) {
        orders.put(order.getId(), order);
    }

    public Order getOrderById(final Long id) {
        return orders.getOrDefault(id, null);
    }

}
