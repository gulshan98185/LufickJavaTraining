package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public class PhotoFileSystem extends InternalFileSystem{
    String uri;

    public PhotoFileSystem(File file) {
//        super();
    }

    @Override
    void improveMemory(File sourceFile) {
        //super.improveMemory(sourceFile);
        System.out.println("PhotoFileSystem: Improving memory "+sourceFile.getAbsolutePath());
    }

    String getUri(File sourceFile){
        System.out.println("PhotoFileSystem: Getting uri "+sourceFile.getAbsolutePath());
        this.uri = "URI";
        return uri;
    }

    @Override
    void move(File sourceFile, File destFolder) {
        //super.move(sourceFile, destFolder);
        System.out.println("PhotoFileSystem: Moving File "+sourceFile.getAbsolutePath());
    }
}
