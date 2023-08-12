package com.example.java_training_august_2023.class_tut.test_file;

import com.example.java_training_august_2023.class_tut.FileSystem;

public class AccessClass {
    FileSystem fileSystem;

    public AccessClass(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public long doWork(){
        return this.fileSystem.getLastModifiedTime();
    }
}
