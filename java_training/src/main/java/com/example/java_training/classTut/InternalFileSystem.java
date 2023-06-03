package com.example.java_training.classTut;

import java.util.ArrayList;
import java.util.List;

public class InternalFileSystem extends FileSystem{

    public InternalFileSystem(String name, int size, String path) {
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

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path){
        this.path = path;
    }



}
