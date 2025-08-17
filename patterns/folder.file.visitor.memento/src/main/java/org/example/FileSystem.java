package org.example;

import java.time.Instant;

public class FileSystem {
    private MyFolder root = new MyFolder();

    public MyFolder getRoot() {
        return root;
    }

    public FileSystemMemento createMemento () {
        FileSystemSnapshot snapshot = new FileSystemSnapshot(Instant.now());
        root.accept(snapshot, null);
        return snapshot;
    }

    public void restore (FileSystemMemento snapshot) {
        if(snapshot instanceof FileSystemSnapshot snapshot2) {
            MyFolder newRoot = new MyFolder();
            for (MyFileSystemObjectSnapShot s : snapshot2) {
                if (s.getType().equals("file")) {
                    MyFile newFile = new MyFile();
                    newFile.setName(s.getName());
                    newFile.setSize(s.getSize());
                    if (s.getParent() == 0) {
                        newRoot.add(newFile);
                    }
                } else if (s.getType().equals("folder")) {
                    MyFolder newFolder = new MyFolder();
                    newFolder.setName(s.getName());
                    for (MyFileSystemObjectSnapShot s2 : snapshot2) {
                        if (s2.getParent() == 1) {

                        }
                    }
                }
            }
        }
    }
}
