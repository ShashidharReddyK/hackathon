package com.service.hackathon.services;

import com.service.hackathon.models.Exchange;
import com.service.hackathon.models.Order;
import com.service.hackathon.models.OrderStatus;
import com.service.hackathon.models.Product;
import com.service.hackathon.models.Return;
import com.service.hackathon.models.User;
import com.service.hackathon.repositories.OrderRepository;
import com.service.hackathon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    public void saveOrder(final List<Product> productList, final long userId) {
        final Order order = new Order(productList, userId);
        final User user = userService.getUser(userId);
        user.getOrders().add(order);
        orderRepository.saveOrder(order);
    }

    public Order getOrder(final long orderid ) {
        return orderRepository.getOrderById(orderid);
    }

    public Order cancelOrder(final long orderId) {
        final Order order = orderRepository.getOrderById(orderId);
        order.setOrderStatus(OrderStatus.CANCELLED);
        return order;
    }

    public Order rescheduleOrder(final long orderId) {
        final Order order = orderRepository.getOrderById(orderId);
        order.setOrderStatus(OrderStatus.ON_HOLD);
        return order;
    }

    public Order createExchange(final long orderId, final long productId) {
        final Order order = orderRepository.getOrderById(orderId);
        Product exchangeProduct = null;
        for(Product product: order.getProductList()) {
            if(product.getId() == productId){
                exchangeProduct = product;
                break;
            }
        }
        if(exchangeProduct == null) return null;
        final Exchange exchange = new Exchange(exchangeProduct, exchangeProduct);
        return order;
    }

    public Return createReturn(final long orderId, final long productId) {
        final Order order = orderRepository.getOrderById(orderId);
        Product returnProduct = null;
        for(Product product: order.getProductList()) {
            if(product.getId() == productId){
                returnProduct = product;
                break;
            }
        }
        if(returnProduct == null) return null;
        final Return  orderReturn  = new Return(orderId, productId);
        return orderReturn;
    }
}
