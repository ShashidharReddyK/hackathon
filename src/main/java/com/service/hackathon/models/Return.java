package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Return extends BaseModel{
    private long orderId;
    private long productId;

    public Return(final long orderId, final long productId) {
        super();
        this.orderId = orderId;
        this.productId = productId;
    }
}
