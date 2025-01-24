package com.service.hackathon.controllers;

import com.service.hackathon.dtos.RequestDto;
import com.service.hackathon.models.Action;
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
    public ResponseEntity<Case> createCase(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        final Action action = requestDto.getAction();
        return new ResponseEntity<>(caseService.createCase(orderId, action), HttpStatus.OK);
    }

    @PostMapping("/updateCommentsInCase")
    public ResponseEntity<Case> updateCommentsInCase(@RequestBody final RequestDto requestDto) {
        final String comment = requestDto.getComment();
        final long caseId = requestDto.getCaseId();
        final Case eCase= caseService.updateComments(caseId, comment);
        return new ResponseEntity<>(eCase, HttpStatus.OK);
    }

    @PostMapping("/cancelOrder")
    public ResponseEntity<Order> cancelOrder(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        return new ResponseEntity<>(orderService.cancelOrder(orderId), HttpStatus.OK);
    }

    @PostMapping("/reschedule")
    public ResponseEntity<Order> rescheduleOrder(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        return new ResponseEntity<>(orderService.rescheduleOrder(orderId), HttpStatus.OK);
    }

    @PostMapping("/exchange")
    public ResponseEntity<Order> createExchange(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        final long productId = requestDto.getProductId();
        return new ResponseEntity<>(orderService.createExchange(orderId, productId), HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<Return> createReturn(@RequestBody final RequestDto requestDto) {
        final long orderId = requestDto.getOrderId();
        final long productId = requestDto.getProductId();
        return new ResponseEntity<>(orderService.createReturn(orderId, productId), HttpStatus.OK);
    }
}
