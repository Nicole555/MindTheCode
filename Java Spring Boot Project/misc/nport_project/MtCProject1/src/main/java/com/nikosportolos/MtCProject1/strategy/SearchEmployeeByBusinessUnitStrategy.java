package com.nikosportolos.MtCProject1.strategy;

import com.nikosportolos.MtCProject1.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeByBusinessUnitStrategy implements SearchEmployeeStrategy {
    @Override
    public List<Employee> execute(Iterable<Employee> allEmployees, Long criteriaId) {

        List<Employee> employees = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getPosition().getUnit().getDepartment().getBusinessUnit().getId() == criteriaId) {
                employees.add(employee);
            }
        }
        return employees;
    }
}
