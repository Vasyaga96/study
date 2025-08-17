package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSystemCaretaker {
    private final ObjectMapper objectMapper;

    public FileSystemCaretaker (ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String addSnapShot(FileSystemSnapshot snapshot) {
        return snapshot.serialize(objectMapper);
    }

    public FileSystemMemento getSnapShot(String name) {
        return null;
    }
}
