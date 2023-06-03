package com.example.java_training.classTut;

import java.util.List;

abstract public class MediaFileSystem extends FileSystem{

    public MediaFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    @Override
    abstract public List<String> listFiles(String path);

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

    public String showThumbnail(){
        String thumbnail = this.path.toLowerCase();
        return thumbnail;
    }
}
