package com.MaintenanceOperatorSystem.MaintenanceBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Maintenance {
    private int id;
    private String Name;
    private int Experience;
}
