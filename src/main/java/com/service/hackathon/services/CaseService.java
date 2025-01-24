package com.service.hackathon.services;

import com.service.hackathon.models.Action;
import com.service.hackathon.models.Case;
import com.service.hackathon.models.User;
import com.service.hackathon.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private OrderService orderService;

    public Case createCase(final long orderId) {
        final Case orderCase = new Case(orderId);
        caseRepository.saveCase(orderId, orderCase);
        return orderCase;
    }

    public Case getCase(final long orderId) {
        return caseRepository.getCase(orderId);
    }
}
