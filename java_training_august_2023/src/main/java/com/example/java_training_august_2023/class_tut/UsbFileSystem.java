package com.example.java_training_august_2023.class_tut;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UsbFileSystem extends FileSystem{

    public UsbFileSystem(String name, String path, int size, long lastModifiedTime) {
        super(name, path, size, lastModifiedTime);
    }

    @Override
    protected List<File> listFiles(File file) {
        return null;
    }

    @Override
    protected boolean move(String initialPath, String finalPath) {
        return false;
    }

    @Override
    protected boolean copy(String initialPath, String finalPath) {
        return false;
    }

    @Override
    protected boolean share(File file) {
        return false;
    }

    @Override
    protected String getFilePath(File file) {
        return null;
    }

    @Override
    protected String rename(String path) {
        return "";
    }

    long getLastModifiedTime(String path){
        return 0L;
    }

    long getSize(String path){
        return 0L;
    }
}
