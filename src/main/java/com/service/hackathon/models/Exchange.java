package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange extends BaseModel{
    private Product inputProduct;
    private Product outputProduct;
    private ExchangeStatus exchangeStatus;

    public Exchange(final Product inputProduct, final Product outputProduct) {
        super();
        this.inputProduct = inputProduct;
        this.outputProduct = outputProduct;
    }

}
