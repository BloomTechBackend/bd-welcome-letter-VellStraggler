package com.bloomtech.welcomeletter;

import com.amazon.ata.test.assertions.PlantUmlClassDiagramAssertions;
import com.amazon.ata.test.helper.AtaTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MasteryTask_2_ClassDiagrams {

    private static final String MODELS_CLASS_DIAGRAM_PATH = "ModelsCD.puml";
    private static final String SERVICES_CLASS_DIAGRAM_PATH = "ServicesCD.puml";

    @ParameterizedTest
    @ValueSource(strings = {"Employee", "Company"})
    void modelsClassDiagram_includesExpectedTypes(String type) {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramContainsClass(content, type);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Role"})
    void modelsClassDiagram_includesExpectedEnums(String type) {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramContainsEnum(content, type);
    }

    @Test
    void modelsClassDiagram_containsRelationshipEmployeeToCompany() {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "Company", "Employee");
    }

    @Test
    void modelsClassDiagram_containsRelationshipEmployeeToRole() {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "Employee", "Role");
    }

    @Test
    void modelsClassDiagram_employeeContainsFields() {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "id");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "firstname");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "lastname");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "phonenumber");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "email");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "salary");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "startdate");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Employee", "role");
    }

    @Test
    void modelsClassDiagram_companyContainsFields() {
        String content = AtaTestHelper.getFileContentFromResources(MODELS_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Company", "id");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Company", "companyname");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMember (content, "Company", "country");
    }

    @Test
    void servicesClassDiagram_containsRelationships() {
        String content = AtaTestHelper.getFileContentFromResources(SERVICES_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "EmployeeService", "EmployeeRepository");
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "EmployeeService", "FormLetterService");
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "EmployeeRepository", "Datasource");
        PlantUmlClassDiagramAssertions.assertClassDiagramIncludesRelationship(content, "FormLetterService", "FileManager");
    }

    @Test
    void servicesClassDiagram_containsMethods() {
        String content = AtaTestHelper.getFileContentFromResources(SERVICES_CLASS_DIAGRAM_PATH);
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "EmployeeService", "getEmployeeById");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "EmployeeService", "sendFormToEmployeeWithId");

        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "EmployeeRepository", "findEmployeeById");

        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "FileManager", "getTextFromFile");
        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "FileManager", "writeTextToFile");

        PlantUmlClassDiagramAssertions.assertClassDiagramTypeContainsMethod (content, "FormLetterService", "generateWelcomeLetter");
    }
}