package com.example.java_training_august_2023.class_tut;

import java.io.File;
import java.util.List;

abstract public class FileSystem {
    private String name;
    private String path;
    private int size;
    private long lastModifiedTime;
    private File file;

    public FileSystem(String name, String path, int size, long lastModifiedTime) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.lastModifiedTime = lastModifiedTime;
        this.file = new File(this.path);
    }

    protected abstract List<File> listFiles(File file);

    protected abstract boolean move(String initialPath, String finalPath);

    protected abstract boolean copy(String initialPath, String finalPath);

    public boolean delete(String path){
        return true;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getSize() {
        return size;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    protected String rename(String path){
        return "name";
    }

    protected abstract boolean share(File file);

    protected abstract String getFilePath(File file);

    protected void setName(String name) {
        this.file = new File(this.file.getParentFile().getPath(), name);
        this.name = name;
    }

    protected void setPath(String path) {
        this.path = path;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    protected void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
