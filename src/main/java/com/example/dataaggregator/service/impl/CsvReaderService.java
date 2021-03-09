package com.example.dataaggregator.service.impl;

import com.example.dataaggregator.model.Machine;
import com.example.dataaggregator.repository.PartOfMachinesRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvReaderService {
    private final PartOfMachinesRepository repository;
    private final List<Machine> machines = new ArrayList<>(100000);

    public CsvReaderService(PartOfMachinesRepository partOfMachinesRepository) {
        this.repository = partOfMachinesRepository;
    }

    public void readFromFileToDb(String filePath) {
        String[] line;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Machine machine = Machine.builder()
                        .owner(line[0])
                        .available(Boolean.parseBoolean(line[1]))
                        .country(line[2])
                        .currency(Currency.getInstance(line[3].toUpperCase()))
                        .machineInfo(line[4])
                        .machineType(line[5])
                        .photoUrl(line[6])
                        .sourceId(Long.parseLong(line[7]))
                        .price(Double.parseDouble(line[8]))
                        .source(line[9])
                        .urlString(line[10])
                        .build();
                machines.add(machine);
                checkList();
            }
            repository.partPersist(machines);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read from file by path: " + filePath, e);
        }
    }

    private void checkList() {
        if (machines.size() == 100000) {
            repository.partPersist(machines);
            machines.clear();
        }
    }
}
