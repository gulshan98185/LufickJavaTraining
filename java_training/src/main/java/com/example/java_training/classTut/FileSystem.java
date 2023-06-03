package com.example.java_training.classTut;

import java.util.ArrayList;
import java.util.List;

abstract public class FileSystem {
    protected String name;
    protected int size;
    protected long createdTime;
    protected String type;

    protected String path;

    public FileSystem(String name, int size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
        this.type = this.name.substring(this.name.indexOf(".")+1);
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public String getType() {
        return type;
    }

    abstract public List<String> listFiles(String path);

    abstract public void copy(String path);

    abstract public void move(String path);

    abstract public void share(String path);

    abstract public int delete(String path);

    abstract public void rename();
}
