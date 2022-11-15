package com.bloomtech.welcomeletter;

import com.amazon.ata.test.assertions.PlantUmlSequenceDiagramAssertions;
import com.amazon.ata.test.helper.AtaTestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MasteryTask_2_SequenceDiagrams {
    private static final String CREATE_WELCOME_LETTER_SEQUENCE_DIAGRAM_PATH = "CreateWelcomeLetterSD.puml";

    @ParameterizedTest
    @ValueSource(strings = {"App", "EmployeeService", "EmployeeRepository", "FormLetterService", "FileManager", "Datasource"})
    void sequenceDiagram_includesExpectedEntities(String type) {
        String content = AtaTestHelper.getFileContentFromResources(CREATE_WELCOME_LETTER_SEQUENCE_DIAGRAM_PATH);
        PlantUmlSequenceDiagramAssertions.assertSequenceDiagramContainsEntity(content, type);
    }

    @ParameterizedTest
    @ValueSource(strings = {"sendFormToEmployeeWithId",
            "getEmployeeById",
            "findEmployeeById",
            "generateWelcomeLetter",
            "getTextFromFile",
            "writeTextToFile"})
    void sequenceDiagram_includesExpectedMethodCalls(String method) {
        String content = AtaTestHelper.getFileContentFromResources(CREATE_WELCOME_LETTER_SEQUENCE_DIAGRAM_PATH);
        PlantUmlSequenceDiagramAssertions.assertSequenceDiagramContainsMethod(content, method);
    }

    @ParameterizedTest
    @ValueSource(strings = {"null",
            "RuntimeException",
            "findEmployeeById",
            "String",
            "Employee"})
    void sequenceDiagram_includesExpectedReturnTypes(String method) {
        String content = AtaTestHelper.getFileContentFromResources(CREATE_WELCOME_LETTER_SEQUENCE_DIAGRAM_PATH);
        PlantUmlSequenceDiagramAssertions.assertSequenceDiagramContainsReturnType(content, method);
    }
}
