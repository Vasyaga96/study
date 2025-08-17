package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.example.MyFileSystemObjectSnapShot.FILE;
import static org.example.MyFileSystemObjectSnapShot.FOLDER;

public class FileSystemSnapshot extends FileSystemMemento implements FileSystemVisitor, Iterable<MyFileSystemObjectSnapShot> {
    private final List<MyFileSystemObjectSnapShot> fileSystemSnapShots = new ArrayList<>();
    private MyFolder lastParent = null;
    private int lastParentIndex = -1;

    public FileSystemSnapshot(Instant creationDate) {
        super(creationDate);
    }

    @Override
    public String serialize(ObjectMapper objectMapper) {
        return "";
    }


    @Override
    public Iterator<MyFileSystemObjectSnapShot> iterator() {
        return fileSystemSnapShots.iterator();
    }

    public void addSnapShot(MyFileSystemObjectSnapShot myFileSystemObjectSnapShot) {
        fileSystemSnapShots.add(myFileSystemObjectSnapShot);
    }
    //Позволяет создать snapShot для файла myFile(параметр), находящейся в папке parent и добавить его в массив fileSystemSnapShots
    @Override
    public void visitFile(MyFile myFile, MyFolder parent) {
        MyFileSystemObjectSnapShot snapShot = new MyFileSystemObjectSnapShot(
                FILE,
                myFile.getName(),
                myFile.getSize(),
                searchParent(parent)
        );
        snapShot.setReference(myFile);
        fileSystemSnapShots.add(snapShot);
    }
    //Позволяет создать snapShot для папки myFolder(параметр), находящейся в папке parent и добавить его в массив fileSystemSnapShots
    @Override
    public void visitFolder(MyFolder myFolder, MyFolder parent) {
        MyFileSystemObjectSnapShot snapShot = new MyFileSystemObjectSnapShot(
                FOLDER,
                myFolder.getName(),
                0L,
                searchParent(parent)
        );
        snapShot.setReference(myFolder);
        fileSystemSnapShots.add(snapShot);
    }

    private int searchParent(MyFolder parent) {
        if(parent == null) {
            return 0;
        }
        if(parent == lastParent) {
            return lastParentIndex;
        }
        for (int i = 0; i < fileSystemSnapShots.size(); i++) {
            MyFileSystemObjectSnapShot current = fileSystemSnapShots.get(i);
            if (current.getReference() == parent) {
                lastParent = parent;
                lastParentIndex = i;
                return i;
            }
        }
        return -1;
    }
}
