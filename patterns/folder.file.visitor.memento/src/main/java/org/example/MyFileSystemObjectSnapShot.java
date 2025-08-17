package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyFileSystemObjectSnapShot {
    public static final String FOLDER = "folder";
    public static final String FILE = "file";

    private String type;
    private String name;
    private Long size;
    private int parent;
    @JsonIgnore
    private MyFileSystemObject reference = null;

    public MyFileSystemObjectSnapShot () {}

    public MyFileSystemObjectSnapShot (String type, String name, Long size, int parent) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public int getParent() {
        return parent;
    }

    public MyFileSystemObject getReference() {
        return reference;
    }

    public void setReference(MyFileSystemObject reference) {
        this.reference = reference;
    }
}
