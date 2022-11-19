package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(Employee employee) throws IOException {
        //TODO: Get template text from resources
        String textFull = fileManager.getTextFromFile("LetterTemplate");
        //TODO: Replace []ed text with correct info
        textFull = textFull.replace("[company name]",employee.getCompany().getCompanyName());
        textFull = textFull.replace("[fullname]",employee.getFirstname() + " " + employee.getLastname());
        textFull = textFull.replace("[startdate]",employee.getStartdate().toString());
        textFull = textFull.replace("[startingsalary]",employee.getSalary() + "");
        textFull = textFull.replace("[company starttime]",employee.getCompany().getCompanyName());
        //TODO: Write finalized String to file
        String outFileName = "Welcome" + employee.getFirstname() + employee.getLastname();
        outFileName = fileManager.addPrefix(fileManager.outFilePrefix,outFileName);
        fileManager.writeTextToFile(outFileName,textFull);
    }
}
