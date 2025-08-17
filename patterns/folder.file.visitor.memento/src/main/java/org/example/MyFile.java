package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyFile implements MyFileSystemObject {
    private String name;
    private Long size;


    @Override
    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public List<MyFileSystemObject> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor, MyFolder parent) {
        fileSystemVisitor.visitFile(this, parent);
    }
}
