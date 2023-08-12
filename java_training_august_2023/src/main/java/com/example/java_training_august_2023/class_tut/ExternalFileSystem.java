package com.example.java_training_august_2023.class_tut;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExternalFileSystem extends InternalFileSystem{
    public ExternalFileSystem(String name, String path, int size, long lastModifiedTime) {
        super(name, path, size, lastModifiedTime);
    }

    @Override
    public boolean share(File file) {
        return true;
    }

    @Override
    public String getFilePath(File file) {
        return "path";
    }
}
