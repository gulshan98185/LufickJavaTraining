package com.example.java_training.classTut;

import java.util.List;

public class OneDriveFileSystem extends CloudFileSystem{
    public OneDriveFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    @Override
    public List<String> listFiles(String path) {
        return null;
    }

    @Override
    public void copy(String path) {

    }

    @Override
    public void move(String path) {

    }

    @Override
    public void share(String path) {

    }

    @Override
    public int delete(String path) {
        return 0;
    }

    @Override
    public void rename() {

    }


}
