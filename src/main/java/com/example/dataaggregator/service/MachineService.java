package com.example.dataaggregator.service;

import com.example.dataaggregator.model.Machine;
import java.util.List;

public interface MachineService {
    Machine save(Machine machine);

    Machine findById(Long id);

    long getNumberOfMachinesByModel(String type);

    List<Machine> getAllByOwner(String owner);

    List<String> getAllModelsByAttribute(String attribute);

    void delete(Long id);
}
