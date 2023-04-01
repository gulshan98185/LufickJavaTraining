package com.example.java_training_march_2023.abstract_class;

import java.io.File;

public class ServerFileSystem extends FileSystem{
    public ServerFileSystem(File file) {
        super(file);
    }

    @Override
    void copy(File sourceFile, File destFolder) {
        upload(sourceFile, destFolder);
    }

    void upload(File sourceFile, File destFolder) {
        System.out.println("ServerFileSystem: Copying file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void move(File sourceFile, File destFolder) {
        uploadAndDelete(sourceFile, destFolder);
    }
    void uploadAndDelete(File sourceFile, File destFolder) {
        System.out.println("ServerFileSystem: Copying file "+sourceFile.getAbsolutePath() + " to folder "+destFolder.getAbsolutePath());
    }

    @Override
    void delete(File sourceFile) {
        System.out.println("ServerFileSystem: Deleting file "+sourceFile.getAbsolutePath());
    }

    @Override
    void setLastModifiedTime(File sourceFile, long time) {
        System.out.println("ServerFileSystem: Setting lastModified time of file "+sourceFile.getAbsolutePath() + " to "+time);
    }
}
