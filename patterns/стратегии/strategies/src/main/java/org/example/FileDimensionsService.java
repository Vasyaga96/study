package org.example;

import java.io.File;

public class FileDimensionsService {
    private final FileDimensionsStrategy[] strategies = {
            new TextFileDimensionsStrategy(),
            new ImageDimensionsStrategy(),
            new GenericFileDimensionsStrategy(),
            new NonExistentFileStrategy()
    };

    public void printFileDimensions(File file) {
        for (FileDimensionsStrategy strategy : strategies) {
            if (strategy.supports(file)) {
                strategy.printDimensions(file);
                return;
            }
        }

        System.out.printf("%s: no known strategies to determine file dimensions\n", file.getName());
    }
}
