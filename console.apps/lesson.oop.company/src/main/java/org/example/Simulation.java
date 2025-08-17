package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public static void simulationOneHours(int hours, List<Employee> employeeList){
        for (Employee employee : employeeList) {
            if (employee.haveTask()) {
                int durationHours = employee.getCurrentTask().getDurationHours() - 1;
                employee.getCurrentTask().setDurationHours(durationHours);
            }
        }
    }
}
