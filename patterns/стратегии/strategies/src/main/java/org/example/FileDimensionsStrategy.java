package org.example;

import java.io.File;

public interface FileDimensionsStrategy {
    boolean supports(File file);
    void printDimensions(File file);
}
