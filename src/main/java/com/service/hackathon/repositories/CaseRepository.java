package com.service.hackathon.repositories;

import com.service.hackathon.models.Case;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CaseRepository {
    private final HashMap<Long, Case> cases;

    public CaseRepository() {
        cases = new HashMap<>();
    }

    public void saveCase(final long orderId, final Case orderCase) {
        cases.put(orderId, orderCase);
    }

    public Case getCase( final Long id) {
        return cases.getOrDefault(id, null);
    }
}
