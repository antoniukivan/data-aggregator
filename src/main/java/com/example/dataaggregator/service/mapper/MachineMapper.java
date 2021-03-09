package com.example.dataaggregator.service.mapper;

import com.example.dataaggregator.model.Machine;
import com.example.dataaggregator.model.dto.MachineRequestDto;
import com.example.dataaggregator.model.dto.MachineResponseDto;
import java.util.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MachineMapper implements DtoMapper<Machine, MachineResponseDto>,
        ModelMapper<Machine, MachineRequestDto> {

    @Override
    public MachineResponseDto getDtoFromModel(Machine machine) {
        return MachineResponseDto.builder()
                .id(machine.getId())
                .owner(machine.getOwner())
                .available(machine.isAvailable())
                .country(machine.getCountry())
                .currency(machine.getCurrency())
                .machineInfo(machine.getMachineInfo())
                .machineType(machine.getMachineType())
                .photoUrl(machine.getPhotoUrl())
                .sourceId(machine.getSourceId())
                .price(machine.getPrice())
                .source(machine.getSource())
                .urlString(machine.getUrlString())
                .build();
    }

    @Override
    public Machine getModelFromDto(MachineRequestDto requestDto) {
        return Machine.builder()
                .owner(requestDto.getOwner())
                .available(requestDto.isAvailable())
                .country(requestDto.getCountry())
                .currency(Currency.getInstance(requestDto.getCurrency().toUpperCase()))
                .machineInfo(requestDto.getMachineInfo())
                .machineType(requestDto.getMachineType())
                .photoUrl(requestDto.getPhotoUrl())
                .sourceId(requestDto.getSourceId())
                .price(requestDto.getPrice())
                .source(requestDto.getSource())
                .urlString(requestDto.getUrlString())
                .build();
    }
}
