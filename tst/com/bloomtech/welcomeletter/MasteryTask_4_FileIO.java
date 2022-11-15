package com.bloomtech.welcomeletter;

import static org.junit.jupiter.api.Assertions.*;
import com.bloomtech.welcomeletter.fileIO.FileManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MasteryTask_4_FileIO {
    @Test
    @Order(1)
    void testFileManager_writeToNewFile() throws IOException {
        FileManager fileManager = new FileManager();
        String contents = "The contents of a test file.";
        fileManager.writeTextToFile("testFile", contents);
    }

    @Test
    @Order(2)
    void testFileManager_readExistingFile() throws IOException {
        FileManager fileManager = new FileManager();
        String expected = "The contents of a test file.\n";
        String fileContents = fileManager.getTextFromFile("out/testFile");
        fileContents = fileContents.replace("\r", "");
        
        assertEquals(expected, fileContents);

        Path path = FileSystems.getDefault().getPath("./src/resources/out/testFile.txt");
        Files.delete(path);
    }
}
