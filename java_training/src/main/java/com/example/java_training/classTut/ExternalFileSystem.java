package com.example.java_training.classTut;

public class ExternalFileSystem extends InternalFileSystem{
    public ExternalFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    @Override
    public void copy(String path) {
    }
}
