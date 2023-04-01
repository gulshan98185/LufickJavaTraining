package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public class InternalFileSystem extends FileSystem{
    public InternalFileSystem() {
        //super(file);
        System.out.println("This is constructor for Internal FileSystem class");
    }

    @Override
    void copy(File sourceFile, File destFolder) {
        System.out.println("InternalFileSystem: Copying file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void move(File sourceFile, File destFolder) {
        System.out.println("InternalFileSystem: Moving file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void delete(File sourceFile) {
        System.out.println("InternalFileSystem: Deleting file "+sourceFile.getAbsolutePath());
    }

    @Override
    void setLastModifiedTime(File sourceFile, long time) {
        System.out.println("InternalFileSystem: Setting file's lastModified Time "+sourceFile.getAbsolutePath() + " to "+time);
    }

    void improveMemory(File sourceFile){
        System.out.println("InternalFileSystem: Improving memory "+sourceFile.getAbsolutePath());
    }


}
