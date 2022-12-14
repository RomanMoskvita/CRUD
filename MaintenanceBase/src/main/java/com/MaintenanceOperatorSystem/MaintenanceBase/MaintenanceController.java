package com.MaintenanceOperatorSystem.MaintenanceBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Maintenances")
public class MaintenanceController {

   @Autowired
   MaintenanceRepository maintenanceRepository;

    @GetMapping("")
    public List<Maintenance> getAll(){

        return maintenanceRepository.getAll();
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable("id") int id)
    {
        return maintenanceRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Maintenance> maintenances) {
        return maintenanceRepository.save(maintenances) ;
    }

        @PutMapping("/{id}")
        public int update(@PathVariable("id") int id, @RequestBody Maintenance updatedMaintenance) {
            Maintenance maintenance = maintenanceRepository.getById(id);
            if (maintenance != null) {
                maintenance.setName(updatedMaintenance.getName());
                maintenance.setExperience(updatedMaintenance.getExperience());

                maintenanceRepository.update(maintenance);
                return 1;
            } else {
                return -1;
            }
        }

        @PatchMapping("/{id}")
        public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Maintenance updatedMaintenance) {
            Maintenance maintenance = maintenanceRepository.getById(id);
            if(maintenance!=null){
                if(updatedMaintenance.getName()!=null) maintenance.setName(updatedMaintenance.getName());
                if(updatedMaintenance.getExperience()>0)maintenance.setExperience((updatedMaintenance.getExperience()));
                maintenanceRepository.update(maintenance);
                return 1;
            }else{
                return -1;
            }
            }

            @DeleteMapping("/{id}")
            public int delete(@PathVariable("id") int id){
                return maintenanceRepository.delete(id);
            }
    }

