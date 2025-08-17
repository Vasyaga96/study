package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] files = {
                "bliss.png",
                "war_and_peace.txt",
                "ddd.pdf",
                "nonexistent.wav"
        };

        FileDimensionsService service = new FileDimensionsService();

        for (String file : files) {
            service.printFileDimensions(new File(file));
        }
    }
}
