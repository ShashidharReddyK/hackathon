package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Case extends BaseModel{
    private long caseNumber;
    private CaseStatus caseStatus;
    private long orderId;
    private List<String> comments;
    private Action action;

    public Case(final long orderId) {
        super();
        this.orderId = orderId;
        caseStatus = CaseStatus.OPEN;
        caseNumber = getRandomId();
        comments = new ArrayList<>();
        this.action = null;
    }
}
