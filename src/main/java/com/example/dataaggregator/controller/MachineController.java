package com.example.dataaggregator.controller;

import com.example.dataaggregator.model.Machine;
import com.example.dataaggregator.model.dto.MachineRequestDto;
import com.example.dataaggregator.model.dto.MachineResponseDto;
import com.example.dataaggregator.service.MachineService;
import com.example.dataaggregator.service.mapper.MachineMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machines")
@AllArgsConstructor
public class MachineController {
    private final MachineService machineService;
    private final MachineMapper machineMapper;

    @GetMapping("/{id}")
    public MachineResponseDto getById(@PathVariable Long id) {
        return machineMapper.getDtoFromModel(machineService.findById(id));
    }

    @PostMapping
    public MachineResponseDto save(@RequestBody MachineRequestDto machineRequestDto) {
        Machine machine = machineMapper.getModelFromDto(machineRequestDto);
        return machineMapper.getDtoFromModel(machineService.save(machine));
    }

    @PutMapping("/{id}")
    public MachineResponseDto update(@PathVariable Long id,
                                     @RequestBody MachineRequestDto machineRequestDto) {
        Machine machine = machineMapper.getModelFromDto(machineRequestDto);
        machine.setId(id);
        return machineMapper.getDtoFromModel(machineService.save(machine));
    }

    @GetMapping("/amount")
    public long getNumberOfMachinesByModel(@RequestParam String model) {
        return machineService.getNumberOfMachinesByModel(model);
    }

    @PostMapping("/by-owner")
    public List<MachineResponseDto> getAllMachinesByOwner(@RequestParam String owner) {
        return machineService.getAllByOwner(owner).stream()
                .map(machineMapper::getDtoFromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/models")
    public List<String> getAllModelWithAttribute(@RequestParam String attribute) {
        return machineService.getAllModelsByAttribute(attribute);
    }
}
