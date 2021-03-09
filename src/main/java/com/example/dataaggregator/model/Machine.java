package com.example.dataaggregator.model;

import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "machines",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"owner", "machine_type", "source_id"})
        }
)
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;

    private boolean available;

    private String country;

    private Currency currency;

    @Column(name = "machine_info")
    private String machineInfo;

    @Column(name = "machine_type")
    private String machineType;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "source_id")
    private long sourceId;

    private double price;

    private String source;

    private String urlString;
}
