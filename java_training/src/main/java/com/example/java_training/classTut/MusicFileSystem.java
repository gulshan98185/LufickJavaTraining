package com.example.java_training.classTut;

import java.util.List;

public class MusicFileSystem extends MediaFileSystem{

    public MusicFileSystem(String name, int size, String path) {
        super(name, size, path);
    }

    @Override
    public List<String> listFiles(String path) {
        return null;
    }

    void play(){

    }

    void pause(){

    }

    void stop(){

    }
}
