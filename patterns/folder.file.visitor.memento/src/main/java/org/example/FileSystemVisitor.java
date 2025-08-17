package org.example;

public interface FileSystemVisitor {
    void visitFile(MyFile myFile,MyFolder parent);
    void visitFolder(MyFolder myFolder, MyFolder parent);
}
