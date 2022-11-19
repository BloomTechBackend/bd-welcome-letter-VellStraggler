package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    public static final String filePrefix = "./src/resources/";
    public static final String outFilePrefix = "./src/resources/out/";
    public FileManager() {
    }
    public static String addPrefix(String prefix, String filename) {
        if (!filename.contains(prefix)) {
            filename = prefix + filename + ".txt";
        }
        return filename;
    }
    public String getTextFromFile(String filename) throws IOException {
        filename = addPrefix(filePrefix, filename);
        File file = new File(filename);
        FileReader filereader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String textLine = bufferedReader.readLine();
        String textFull = "";
        while (textLine != null) {
            if (!textLine.contains("\n")) {
                textLine += "\n";
            }
            textFull = textFull + textLine;
            textLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return textFull;
    }

    public void writeTextToFile(String outFileName, String text) throws IOException {
        outFileName = addPrefix(outFilePrefix, outFileName);
        File outFile = new File(outFileName);
        FileWriter outFileWriter = new FileWriter(outFile);
        BufferedWriter bufferedWriter = new BufferedWriter(outFileWriter);
        bufferedWriter.write(text);
        bufferedWriter.close();
    }
}