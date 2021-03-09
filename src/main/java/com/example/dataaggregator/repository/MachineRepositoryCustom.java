package com.example.dataaggregator.repository;

import java.util.List;

public interface MachineRepositoryCustom {
    List<String> getAllModelsByAttribute(String attribute);
}
