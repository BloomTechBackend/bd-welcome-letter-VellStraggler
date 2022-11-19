package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(Employee employee) throws IOException {
        //TODO: Get template text from resources
        String textFull = fileManager.getTextFromFile("C:\\Users\\david\\bloomtech\\bd-welcome-letter-VellStraggler\\src\\resources\\LetterTemplate.txt");
        //TODO: Replace []ed text with correct info
        textFull.replaceAll("[company name]",employee.getCompany().getCompanyName());
        textFull.replaceAll("[fullname]",employee.getFirstname() + " " + employee.getLastname());
        textFull.replaceAll("[startdate]",employee.getStartdate().toString());
        textFull.replaceAll("[startingsalary]",employee.getSalary() + "");
        textFull.replaceAll("[starttime]",employee.getStartdate().atStartOfDay().toString());
        //TODO: Write finalized String to file
        System.out.println(textFull);
    }
}
