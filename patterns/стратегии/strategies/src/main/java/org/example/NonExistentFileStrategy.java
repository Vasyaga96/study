package org.example;

import java.io.File;

public class NonExistentFileStrategy implements FileDimensionsStrategy {
    @Override
    public boolean supports(File file) {
        return !file.isFile();
    }

    @Override
    public void printDimensions(File file) {
        System.out.printf("%s: does not exist or not a file\n", file.getName());
    }
}
