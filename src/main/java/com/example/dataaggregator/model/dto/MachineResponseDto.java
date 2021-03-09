package com.example.dataaggregator.model.dto;

import java.util.Currency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MachineResponseDto {
    private Long id;
    private String owner;
    private boolean available;
    private String country;
    private Currency currency;
    private String machineInfo;
    private String machineType;
    private String photoUrl;
    private long sourceId;
    private double price;
    private String source;
    private String urlString;
}
