package com.bloomtech.welcomeletter.repositories;

import com.bloomtech.welcomeletter.datasources.Datasource;
import com.bloomtech.welcomeletter.models.Employee;

import java.util.Optional;

public class EmployeeRepository {
    private Datasource datasource;

    public EmployeeRepository(Datasource datasource) {
        this.datasource = datasource;
    }

    public Optional<Employee> findEmployeeById(int id) {
        return datasource.employees
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
}
