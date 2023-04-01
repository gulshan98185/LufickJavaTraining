package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public class TestFileSystem {
    public static void main(String[] args) {
        FileSystem fileSystem = new PhotoFileSystem(new File("xljdlj"));
        fileSystem.move(new File("xljdlj"), new File("trl;rsjfgdjlk"));
//        fileSystem.getLastModifiedTime(new File("0/downloads/xyz.jpg"));
//        fileSystem.improveMemory(new File("0/downloads/xyz.jpg"));
//        String uri = fileSystem.getUri(new File("0/downloads/xyz.jpg"));
//        System.out.println("Uri is "+uri);
//
//        FileSystem fileSystem1  = new InternalFileSystem();
    }
}
