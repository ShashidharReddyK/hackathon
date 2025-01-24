package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order extends BaseModel {
    private List<Product> productList;
    private DeliveryStatus deliveryStatus;
    private OrderStatus orderStatus;
    private long caseId;
    private long userId;
    private Return aReturn;
    private Exchange exchange;

    public Order(final List<Product> productList, final long userId) {
        super();
        this.productList = productList;
        this.userId = userId;
        this.deliveryStatus = DeliveryStatus.NOT_PICKED_UP;
    }
}
