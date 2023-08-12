package com.example.java_training_august_2023.class_tut;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InternalFileSystem extends FileSystem{

    public InternalFileSystem(String name, String path, int size, long lastModifiedTime) {
        super(name, path, size, lastModifiedTime);
    }

    @Override
    public List<File> listFiles(File file) {
        List<File> list = new ArrayList<>();

        return list;
    }

    @Override
    public boolean move(String initialPath, String finalPath) {
        return false;
    }

    @Override
    public boolean copy(String initialPath, String finalPath) {
        return false;
    }

    @Override
    public boolean share(File file) {
        return false;
    }

    @Override
    public String getFilePath(File file) {
        return null;
    }


}
