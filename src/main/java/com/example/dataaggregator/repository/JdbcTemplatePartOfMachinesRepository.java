package com.example.dataaggregator.repository;

import com.example.dataaggregator.model.Machine;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JdbcTemplatePartOfMachinesRepository implements PartOfMachinesRepository {
    private final JdbcTemplate template;

    @Override
    @Transactional
    public void partPersist(List<Machine> entities) {
        template.batchUpdate("INSERT INTO machines (owner, available, country, currency, "
                        + "machine_info, machine_type, photo_url, source_id, price, source, "
                        + "url_string) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                        + "ON DUPLICATE KEY UPDATE available = ?, country = ?, currency = ?, "
                        + "machine_info = ?, photo_url = ?, price = ?, source = ?, url_string = ?",
                new BatchPreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps, int index) throws SQLException {
                        ps.setString(1, entities.get(index).getOwner());
                        ps.setBoolean(2, entities.get(index).isAvailable());
                        ps.setString(3, entities.get(index).getCountry());
                        ps.setString(4, entities.get(index).getCurrency().toString());
                        ps.setString(5, entities.get(index).getMachineInfo());
                        ps.setString(6, entities.get(index).getMachineType());
                        ps.setString(7, entities.get(index).getPhotoUrl());
                        ps.setLong(8, entities.get(index).getSourceId());
                        ps.setDouble(9, entities.get(index).getPrice());
                        ps.setString(10, entities.get(index).getSource());
                        ps.setString(11, entities.get(index).getUrlString());
                        ps.setBoolean(12, entities.get(index).isAvailable());
                        ps.setString(13, entities.get(index).getCountry());
                        ps.setString(14, entities.get(index).getCurrency().toString());
                        ps.setString(15, entities.get(index).getMachineInfo());
                        ps.setString(16, entities.get(index).getPhotoUrl());
                        ps.setDouble(17, entities.get(index).getPrice());
                        ps.setString(18, entities.get(index).getSource());
                        ps.setString(19, entities.get(index).getUrlString());
                    }

                    @Override
                    public int getBatchSize() {
                        return entities.size();
                    }
                });
    }
}
