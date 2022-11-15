package com.bloomtech.welcomeletter;

import com.bloomtech.welcomeletter.datasources.Datasource;
import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Company;
import com.bloomtech.welcomeletter.models.Employee;
import com.bloomtech.welcomeletter.models.Role;
import com.bloomtech.welcomeletter.repositories.EmployeeRepository;
import com.bloomtech.welcomeletter.services.EmployeeService;
import com.bloomtech.welcomeletter.services.FormLetterService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasteryTask_4_FormLetterService {
    @Test
    void generateFormLetter_returnsWelcomeLetter() throws IOException {
        FileManager fileManager = new FileManager();
        FormLetterService formLetterService = new FormLetterService();
        Datasource datasource = new Datasource();
        Company company = Company.builder().withCompanyname("test company").build();
        Employee employee = Employee.builder()
                .withFirstname("Test")
                .withLastname("Employee")
                .withStartdate(LocalDate.of(2022, 8, 30))
                .withSalary(100000)
                .withRole(Role.ENGINEERING)
                .withCompany(company)
                .build();
        datasource.employees.add(employee);
        EmployeeRepository employeeRepository = new EmployeeRepository(datasource);
        EmployeeService employeeService = new EmployeeService(employeeRepository, formLetterService);

        employeeService.sendFormToEmployeeWithId(employee.getId());

        String welcomeLetter = fileManager.getTextFromFile("out/WelcomeTestEmployee");
        welcomeLetter = welcomeLetter.replace("\r", "");
        String expected = "Welcome to test company!\n" +
                "\n" +
                "Dear Test Employee,\n" +
                "\n" +
                "We are all really excited to welcome you to our team! As agreed, your start date will be 2022-08-30 and\n" +
                "your starting salary is $100000.\n" +
                "We expect to see you in our offices at test company.\n" +
                "\n" +
                "We are looking forward to working with you!\n";

        assertEquals(expected, welcomeLetter);

        Path path = FileSystems.getDefault().getPath("./src/resources/out/WelcomeTestEmployee.txt");
        Files.delete(path);
    }
}
