package com.example.dataaggregator.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MachineRepositoryCustomImpl implements MachineRepositoryCustom {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<String> getAllModelsByAttribute(String attribute) {
        String query = "SELECT DISTINCT m.machineType FROM Machine m WHERE m.machineInfo LIKE "
                + "'%" + attribute + "%'";
        Query entityManagerQuery = entityManager.createQuery(query);
        return (List<String>) entityManagerQuery.getResultList();
    }
}
