package com.example.dataaggregator;

import com.example.dataaggregator.service.impl.CsvReaderService;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataAggregatorApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext
                = SpringApplication.run(DataAggregatorApplication.class, args);
        CsvReaderService csvReaderService
                = configurableApplicationContext.getBean(CsvReaderService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter CSV file path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter 'START' to save data from this file to the db");

        if (scanner.nextLine().equalsIgnoreCase("start")) {
            csvReaderService.readFromFileToDb(filePath);
        }
    }
}
