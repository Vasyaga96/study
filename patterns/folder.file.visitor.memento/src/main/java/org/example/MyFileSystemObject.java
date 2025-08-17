package org.example;

import java.util.List;

public interface MyFileSystemObject {
    String getName();
    List<MyFileSystemObject> getChildren();

    void accept(FileSystemVisitor fileSystemVisitor, MyFolder parent);
}
