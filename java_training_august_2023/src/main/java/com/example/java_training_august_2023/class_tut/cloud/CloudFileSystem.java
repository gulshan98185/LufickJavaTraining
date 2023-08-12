package com.example.java_training_august_2023.class_tut.cloud;

import com.example.java_training_august_2023.class_tut.FileSystem;

import java.io.File;
import java.util.List;

abstract public class CloudFileSystem extends FileSystem {
    private String id;
    public CloudFileSystem(String name, String path, int size, long lastModifiedTime, String id) {
        super(name, path, size, lastModifiedTime);
        this.id = id;
    }

    abstract List<File> download(String path);

   abstract boolean upload(String path);

    abstract long getAvailableSize(String path);

    abstract void updateAvailableSize(String id, String payment_id);
    abstract void updateSize(String payment_id);

    public String getId() {
        return id;
    }
}
