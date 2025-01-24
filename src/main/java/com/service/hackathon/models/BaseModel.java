package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class BaseModel {
    @Getter
    private long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean isDeleted;
    private final Random random = new Random();

    protected long getRandomId() {
        return random.nextLong();
    }

    public BaseModel() {
        this.id = getRandomId();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
}
