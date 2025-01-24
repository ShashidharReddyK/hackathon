package com.service.hackathon.dtos;

import com.service.hackathon.models.Action;
import com.service.hackathon.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestDto {
    private long orderId;
    private long caseId;
    private long caseNumber;
    private long productId;
    private long userId;
    private long returnId;
    private long exchangeId;
    private List<Product> productList;
    private String productName;
    private double price;
    private String phone;
    private Action action;
    private String comment;
}

