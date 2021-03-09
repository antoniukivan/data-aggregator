package com.example.dataaggregator.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MachineRequestDto {
    private String owner;
    private boolean available;
    private String country;
    private String currency;
    private String machineInfo;
    private String machineType;
    private String photoUrl;
    private long sourceId;
    private double price;
    private String source;
    private String urlString;
}
