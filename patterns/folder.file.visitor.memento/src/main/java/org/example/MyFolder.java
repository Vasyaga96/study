package org.example;

import java.util.List;

public class MyFolder implements MyFileSystemObject {
    private String name;
    private List<MyFileSystemObject> children;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<MyFileSystemObject> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<MyFileSystemObject> children) {
        this.children = children;
    }

    public void add(MyFileSystemObject f) {
        children.add(f);
    }

    public void remove(String name) {
        for (int i = 0; i < children.size(); i++) {
            String nameChild = children.get(i).getName();
            if (nameChild.equals(name)) {
                children.remove(i);
                return;
            }
        }
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor, MyFolder parent) {
        fileSystemVisitor.visitFolder(this,parent);
        for (MyFileSystemObject child : children) {
            child.accept(fileSystemVisitor,this);
        }
    }
}
