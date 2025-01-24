package com.service.hackathon.controllers;

import com.service.hackathon.models.Case;
import com.service.hackathon.models.Order;
import com.service.hackathon.models.Return;
import com.service.hackathon.services.CaseService;
import com.service.hackathon.services.OrderService;
import com.service.hackathon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Case> createCase(@RequestBody final long orderId,
                                     @RequestBody final long userId) {
        return new ResponseEntity<>(caseService.createCase(orderId), HttpStatus.OK);

    }

    @PostMapping("/cancelOrder")
    public ResponseEntity<Order> cancelOrder(@RequestBody final long orderId) {
        return new ResponseEntity<>(orderService.cancelOrder(orderId), HttpStatus.OK);
    }

    @PostMapping("/reschedule")
    public ResponseEntity<Order> rescheduleOrder(@RequestBody final long orderId) {
        return new ResponseEntity<>(orderService.rescheduleOrder(orderId), HttpStatus.OK);
    }

    @PostMapping("/exchange")
    public ResponseEntity<Order> createExchange(@RequestBody final long orderId,
                               @RequestBody final long productId) {
        return new ResponseEntity<>(orderService.createExchange(orderId, productId), HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<Return> createReturn(@RequestBody final long orderId,
                                               @RequestBody final long productId) {
        return new ResponseEntity<>(orderService.createReturn(orderId, productId), HttpStatus.OK);
    }
}
