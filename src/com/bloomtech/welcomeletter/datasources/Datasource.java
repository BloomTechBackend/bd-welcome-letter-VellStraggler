package com.bloomtech.welcomeletter.datasources;

import com.bloomtech.welcomeletter.models.Company;
import com.bloomtech.welcomeletter.models.Employee;
import com.bloomtech.welcomeletter.models.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final List<Company> companies = new ArrayList<>();
    public static final List<Employee> employees = new ArrayList<>();

    public Datasource() {
        Company company1 = Company.builder()
                .withCompanyname("US Company")
                .withCountry("USA")
                .build();

        Company company2 = Company.builder()
                .withCompanyname("Paper Company")
                .build();

        companies.add(company1);
        companies.add(company2);

        Employee emp1 = Employee.builder()
                .withFirstname("Lucia")
                .withLastname("Hill")
                .withPhonenumber("123-456-7890")
                .withStartdate(LocalDate.of(2022, 6, 30))
                .withEmail("riverlinkai@email.com")
                .withSalary(90000)
                .withRole(Role.COORDINATOR)
                .withCompany(company1)
                .build();

        Employee emp2 = Employee.builder()
                .withFirstname("Ian")
                .withLastname("Lugo")
                .withSalary(50000)
                .withCompany(company2)
                .withStartdate(LocalDate.now())
                .build();

        employees.add(emp1);
        employees.add(emp2);
    }
}
