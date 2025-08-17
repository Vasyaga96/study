package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        FileSystemCaretaker caretaker = new FileSystemCaretaker(objectMapper);
        FileSystem fileSystem = new FileSystem();
    }
}
