package org.example;

import java.io.File;

public class GenericFileDimensionsStrategy implements FileDimensionsStrategy {
    @Override
    public boolean supports(File file) {
        return file.isFile();
    }

    @Override
    public void printDimensions(File file) {
        long dimension = file.length();
        System.out.printf("%s: %d bytes\n", file.getName(), dimension);
    }
}
