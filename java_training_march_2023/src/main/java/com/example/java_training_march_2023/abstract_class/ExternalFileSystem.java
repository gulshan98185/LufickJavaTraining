package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public class ExternalFileSystem extends FileSystem{
    public ExternalFileSystem(File file) {
        super(file);
    }

    @Override
    void copy(File sourceFile, File destFolder) {
        System.out.println("ExternalFileSystem: Copying file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void move(File sourceFile, File destFolder) {
        System.out.println("ExternalFileSystem: Copying file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void delete(File sourceFile) {
        System.out.println("ExternalFileSystem: Deleting file "+sourceFile.getAbsolutePath());
    }

    @Override
    void setLastModifiedTime(File sourceFile, long time) {
        System.out.println("ExternalFileSystem: Setting lastModified time of file "+sourceFile.getAbsolutePath() + " to "+time);
    }
}
