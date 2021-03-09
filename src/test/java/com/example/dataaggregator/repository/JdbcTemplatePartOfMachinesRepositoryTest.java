package com.example.dataaggregator.repository;

import com.example.dataaggregator.model.Machine;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class JdbcTemplatePartOfMachinesRepositoryTest {
    private static final int SIZE = 1_000_000;
    private static List<Machine> machines;

    @Autowired
    private PartOfMachinesRepository partOfMachinesRepository;

    @Autowired
    private MachineRepository machineRepository;

    @BeforeAll
    static void beforeAll() {
        machines = new ArrayList<>();
        createEntities();
    }

    @Test
    void partPersist() {
        long start = System.currentTimeMillis();
        partOfMachinesRepository.partPersist(machines);
        long end = System.currentTimeMillis();

        List<String> allModelsByAttribute = machineRepository.getAllModelsByAttribute("info");

        Assertions.assertEquals(21, allModelsByAttribute.size());
        Assertions.assertTrue((end - start) / 1000000 < 50);
    }

    private static void createEntities() {
        for (int i = 1; i <= SIZE; i++) {
            machines.add(Machine.builder()
                    .owner(i % 17 + "")
                    .available(true)
                    .country(i + "")
                    .currency(Currency.getInstance("USD"))
                    .machineInfo("type" + i + "info")
                    .machineType(i % 21 + "")
                    .photoUrl(i + "")
                    .sourceId(i % 31)
                    .price(i)
                    .source(i + "")
                    .urlString(i + "")
                    .build());
        }
    }
}