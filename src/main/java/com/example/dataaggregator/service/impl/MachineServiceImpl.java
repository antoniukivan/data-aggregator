package com.example.dataaggregator.service.impl;

import com.example.dataaggregator.model.Machine;
import com.example.dataaggregator.repository.MachineRepository;
import com.example.dataaggregator.service.MachineService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;

    @Override
    public Machine save(Machine machine) {
        if (machine.getId() != null) {
            return machineRepository.save(machine);
        }
        Optional<Machine> machineOptional = machineRepository
                .findByOwnerAndMachineTypeAndSourceId(machine.getOwner(),
                        machine.getMachineType(), machine.getSourceId());
        machineOptional.ifPresent(value -> machine.setId(value.getId()));
        return machineRepository.save(machine);
    }

    @Override
    public Machine findById(Long id) {
        return machineRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't find machine by id: " + id));
    }

    @Override
    public long getNumberOfMachinesByModel(String machineType) {
        return machineRepository.countAllByMachineType(machineType);
    }

    @Override
    public List<Machine> getAllByOwner(String owner) {
        return machineRepository.getAllByOwner(owner);
    }

    @Override
    public List<String> getAllModelsByAttribute(String attribute) {
        return machineRepository.getAllModelsByAttribute(attribute);
    }

    @Override
    public void delete(Long id) {
        machineRepository.deleteById(id);
    }
}
