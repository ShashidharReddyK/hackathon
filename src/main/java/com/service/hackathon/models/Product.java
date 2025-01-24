package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

    private String productName;
    private double price;
    private Availability availability;

    public Product(final String productName, final  double price) {
        super();
        this.productName = productName;
        this.availability = Availability.AVAILABLE;
        this.price = price;
    }
}
