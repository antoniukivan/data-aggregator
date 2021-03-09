package com.example.dataaggregator.service.impl;

import com.example.dataaggregator.model.Machine;
import com.example.dataaggregator.repository.MachineRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CsvReaderServiceTest {
    private static final String FILE_PATH = "src/test/resources/Sample_data_BackendTask2.csv";

    @Autowired
    private CsvReaderService csvReaderService;

    @Autowired
    private MachineRepository machineRepository;

    @Test
    void readFromFileToDb() {
        csvReaderService.readFromFileToDb(FILE_PATH);

        long allByMachineType = machineRepository.countAllByMachineType("straw blowers/bale splitters");
        Assertions.assertEquals(7, allByMachineType);

        List<String> allModelsByAttribute = machineRepository.getAllModelsByAttribute("Round bales");
        Assertions.assertEquals(List.of("straw blowers/bale splitters"), allModelsByAttribute);

        List<Machine> allByOwner = machineRepository.getAllByOwner("Fiona Walter");
        Assertions.assertEquals("sweden", allByOwner.get(0).getCountry());
    }
}
