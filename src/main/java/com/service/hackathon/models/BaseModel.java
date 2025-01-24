package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BaseModel {
    private long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean isDeleted;
    static long random = 10000000L;

    protected long getRandomId() {
        return ++random;
    }

    public BaseModel() {
        this.id = getRandomId();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
}
