package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.repositories.EmployeeRepository;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class EmployeeService {
    private FormLetterService formLetterService;
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, FormLetterService formLetterService) {
        this.employeeRepository = employeeRepository;
        this.formLetterService = formLetterService;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.findEmployeeById(id).
                orElseThrow(()-> new RuntimeException("No employee found with id: " + id));
        return employee;
    }

    public void sendFormToEmployeeWithId(int id) throws IOException {
        Employee employee = getEmployeeById(id);
        formLetterService.generateWelcomeLetter(employee);
    }
}
