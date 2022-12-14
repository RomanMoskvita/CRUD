package com.MaintenanceOperatorSystem.MaintenanceBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MaintenanceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Maintenance> getAll() {
        return jdbcTemplate.query("SELECT id, Name, Experience FROM maintenance",
                BeanPropertyRowMapper.newInstance(Maintenance.class));
    }

    public Maintenance getById(int id) {
       return jdbcTemplate.queryForObject("SELECT id, Name, Experience FROM maintenance WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(Maintenance.class), id);
    }

    public int save(List<Maintenance> maintenances) {
          maintenances.forEach(maintenance ->  jdbcTemplate.update("INSERT INTO maintenance(Name, Experience) VALUES(?, ?) ",
                  maintenance.getName(), maintenance.getExperience() ));
        maintenances.forEach(maintenance -> System.out.println(maintenance.getName() + maintenance.getExperience()));
        return 1;
    }

    public int update(Maintenance maintenance){
      return  jdbcTemplate.update("UPDATE maintenance SET Name=?, Experience=? WHERE id=?",
                maintenance.getName(),maintenance.getExperience(), maintenance.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM maintenance WHERE id=?", id);
    }
}



