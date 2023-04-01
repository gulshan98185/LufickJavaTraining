package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public abstract class FileSystem {
    String path;
    long lastModifiedTime;
    private String name;
    long size;

    File file;

    public FileSystem(File file){
        this.file = file;
    }

    public FileSystem(){
        System.out.println("This is constructor for abstract class");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getName() {
        this.name = this.file.getName();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    abstract void copy(File sourceFile, File destFolder);

    abstract void move(File sourceFile, File destFolder);

    abstract void delete(File sourceFile);

    long getSize(File sourceFile){
        return sourceFile.length();
    }

    abstract void setLastModifiedTime(File sourceFile, long time);

    final long getLastModifiedTime(File source){
        System.out.println("Getting last modified from abstract class");
        return source.lastModified();
    }

    void setFileName(File sourceFile, String name){
        sourceFile.renameTo(new File(sourceFile.getParentFile().getAbsolutePath()+"/"+name));
    }
}
