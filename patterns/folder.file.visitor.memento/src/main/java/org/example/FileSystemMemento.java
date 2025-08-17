package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;

public abstract class FileSystemMemento {
    private final Instant creationDate;

    public FileSystemMemento(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public abstract String serialize(ObjectMapper objectMapper);
}
