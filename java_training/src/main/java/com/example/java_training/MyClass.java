package com.example.java_training;

import com.example.java_training.access_modifier.Main;
import com.example.java_training.classTut.CloudFileSystem;
import com.example.java_training.classTut.FileSystem;
import com.example.java_training.classTut.GoogleDriveFileSystem;
import com.example.java_training.classTut.InternalFileSystem;
import com.example.java_training.classTut.MediaFileSystem;
import com.example.java_training.classTut.MusicFileSystem;

public class MyClass {
    public static void main(String[] args) {
////        System.out.println("Hello World");
//        Main main = new Main();//        System.out.println(main.a);
////        System.out.println(main.b);
//        System.out.println(main.c);
////        System.out.println(main.d);// not allowed protected variable
//
////        main.a = 5;
////        b = "x"; // not allowed private variable
//        main.c = 3.0f;
////        main.d = 3000;// not allowed protected variable

        CloudFileSystem fileSystem = new GoogleDriveFileSystem("xyx.jpg", 100, "0/download/xyz.jpg");
        fileSystem.setName("xyz.jpg");
        fileSystem.copy(fileSystem.getPath());
        fileSystem.upload(fileSystem.getPath());

    }
}