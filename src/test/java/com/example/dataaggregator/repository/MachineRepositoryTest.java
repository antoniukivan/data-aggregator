package com.example.dataaggregator.repository;

import com.example.dataaggregator.model.Machine;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class MachineRepositoryTest {
    private static final int SIZE = 100;
    private static List<Machine> machines;

    @Autowired
    private MachineRepository machineRepository;

    @BeforeAll
    static void beforeAll() {
        machines = new ArrayList<>();
        createEntities();
    }

    @Test
    void countAllByMachineType() {
        machineRepository.saveAll(machines);
        long allByMachineType = machineRepository.countAllByMachineType(1 + "");
        Assertions.assertEquals(5, allByMachineType, 5 + " expected");
        allByMachineType = machineRepository.countAllByMachineType(2 + "");
        Assertions.assertEquals(5, allByMachineType, 5 + " expected");
        allByMachineType = machineRepository.countAllByMachineType(3 + "");
        Assertions.assertEquals(5, allByMachineType, 5 + " expected");
        allByMachineType = machineRepository.countAllByMachineType(4 + "");
        Assertions.assertEquals(5, allByMachineType, 5 + " expected");
    }

    @Test
    void getAllByOwner() {
        machineRepository.saveAll(machines);
        List<Machine> allByOwner = machineRepository.getAllByOwner(1 + "");
        Assertions.assertEquals(6, allByOwner.size());
        allByOwner = machineRepository.getAllByOwner(2 + "");
        Assertions.assertEquals(6, allByOwner.size());
    }

    @Test
    void getAllModelsByAttribute() {
        machineRepository.saveAll(machines);
        List<String> allModelsByAttribute = machineRepository.getAllModelsByAttribute("info");
        System.out.println(allModelsByAttribute);
        Assertions.assertEquals(21, allModelsByAttribute.size());
    }

    @Test
    void findByOwnerAndMachineTypeAndSourceId() {
        machineRepository.saveAll(machines);
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
