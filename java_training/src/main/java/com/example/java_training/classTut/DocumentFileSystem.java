package com.example.java_training.classTut;

import java.util.List;

public class DocumentFileSystem extends MediaFileSystem{
    public DocumentFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    @Override
    public List<String> listFiles(String path) {
        return null;
    }

    public void open(){

    }

    public void writeInDocs(String content){

    }
}
