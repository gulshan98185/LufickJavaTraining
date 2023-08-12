package com.example.java_training_august_2023.class_tut.test_file;

import com.example.java_training_august_2023.class_tut.ExternalFileSystem;
import com.example.java_training_august_2023.class_tut.InternalFileSystem;

public class TestFileSystem {
    public static void main(String[] args) {
        InternalFileSystem internalFileSystem = new InternalFileSystem("xyz", "0/downloads/path", 2000, 100000000L);
        ExternalFileSystem externalFileSystem = new ExternalFileSystem("xyz", "0/downloads/path", 2000, 100000000L);
        internalFileSystem.copy(internalFileSystem.getPath(), "0/downloads");
        internalFileSystem.move(internalFileSystem.getPath(), "0/downloads");
        internalFileSystem.delete(internalFileSystem.getPath());

        AccessClass accessClass = new AccessClass(externalFileSystem);
        long value = accessClass.doWork();
    }
}
