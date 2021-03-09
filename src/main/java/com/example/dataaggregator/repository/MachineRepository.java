package com.example.dataaggregator.repository;

import com.example.dataaggregator.model.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long>, MachineRepositoryCustom {
    long countAllByMachineType(String machineType);

    List<Machine> getAllByOwner(String owner);

    Optional<Machine> findByOwnerAndMachineTypeAndSourceId(String owner,
                                                           String machineType, long sourceId);
}
