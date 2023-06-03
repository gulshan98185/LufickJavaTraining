package com.example.java_training.classTut;

abstract public class CloudFileSystem extends FileSystem{
    public CloudFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    public void upload(String path){

    }
    String download(String name){
        String path = name.toLowerCase();
        return path;
    }
}
