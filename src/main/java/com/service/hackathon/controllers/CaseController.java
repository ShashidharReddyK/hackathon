package com.service.hackathon.controllers;

import com.service.hackathon.models.Case;
import com.service.hackathon.models.Order;
import com.service.hackathon.models.User;
import com.service.hackathon.services.CaseService;
import com.service.hackathon.services.OrderService;
import com.service.hackathon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private UserService userService;

    @PostMapping("/createCase")
    public Case createCase(@PathVariable("orderId") final long orderId,
                           @PathVariable("usesrId") final long userId) {
        return caseService.createCase(orderId);
    }

    @PostMapping("/cancelOrder")
    public void cancelOrder(@PathVariable("orderId") final long orderId) {
        orderService.cancelOrder(orderId);
    }

    @PostMapping("/reschedule")
    public void rescheduleOrder(@PathVariable("orderId") final long orderId) {
        orderService.rescheduleOrder(orderId);
    }

    @PostMapping("/exchange")
    public void createExchange(@PathVariable("orderId") final long orderId,
                               @PathVariable("productId") final long productId) {
        orderService.createExchange(orderId, productId);
    }

    @PostMapping("/exchange")
    public void createReturn(@PathVariable("orderId") final long orderId,
                             @PathVariable("productId") final long productId) {
        orderService.createReturn(orderId, productId);
    }
}
