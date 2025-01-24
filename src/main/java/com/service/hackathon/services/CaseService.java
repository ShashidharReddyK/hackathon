package com.service.hackathon.services;

import com.service.hackathon.models.Action;
import com.service.hackathon.models.Case;
import com.service.hackathon.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private OrderService orderService;

    public Case createCase(final long orderId, final Action action) {
        final Case orderCase = new Case(orderId, action);
        caseRepository.saveCase(orderCase);
        return orderCase;
    }

    public Case getCaseByCaseId(final long caseId) {
        return caseRepository.getCase(caseId);
    }

    public Case updateComments(final long caseId, final String comment) {
        final Case eCase = getCaseByCaseId(caseId);
        eCase.getComments().add(comment);
        return eCase;
    }
}
