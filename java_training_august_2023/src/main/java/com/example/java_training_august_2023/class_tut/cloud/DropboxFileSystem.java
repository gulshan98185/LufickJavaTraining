package com.example.java_training_august_2023.class_tut.cloud;

import com.example.java_training_august_2023.class_tut.cloud.CloudFileSystem;

import java.io.File;
import java.util.List;

public class DropboxFileSystem extends CloudFileSystem {
    public DropboxFileSystem(String name, String path, int size, long lastModifiedTime, String id) {
        super(name, path, size, lastModifiedTime, id);
    }

    @Override
    List<File> download(String path) {
        return null;
    }

    @Override
    boolean upload(String path) {
        return false;
    }

    @Override
    long getAvailableSize(String path) {
        return 0;
    }

    @Override
    void updateAvailableSize(String id, String payment_id) {

    }

    @Override
    void updateSize(String payment_id) {

    }

    @Override
    protected List<File> listFiles(File file) {
        return null;
    }

    @Override
    protected boolean move(String initialPath, String finalPath) {
        return false;
    }

    @Override
    protected boolean copy(String initialPath, String finalPath) {
        return false;
    }

    @Override
    protected boolean share(File file) {
        return false;
    }

    @Override
    protected String getFilePath(File file) {
        return null;
    }
}
