package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextFileDimensionsStrategy implements FileDimensionsStrategy {
    @Override
    public boolean supports(File file) {
        return file.getName().toLowerCase().endsWith(".txt");
    }

    @Override
    public void printDimensions(File file) {
        try {
            int chars = Files.readString(file.toPath()).length();
            System.out.printf("%s: %d characters\n", file.getName(), chars);
        } catch (IOException e) {
            System.out.printf("%s: error reading file (%s)\n", file.getName(), e.getMessage());
        }
    }
}
