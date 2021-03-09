package com.example.dataaggregator.repository;

import com.example.dataaggregator.model.Machine;
import java.util.List;

public interface PartOfMachinesRepository {
    void partPersist(List<Machine> entities);
}
