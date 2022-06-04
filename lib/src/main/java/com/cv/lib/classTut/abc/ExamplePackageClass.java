package com.cv.lib.classTut.abc;

public class ExamplePackageClass {
    public static void main(String[] args) {
//        CloudFileSystem cloudFileSystem = new CloudFileSystem(true, true, 25);
//        cloudFileSystem.run();
//        cloudFileSystem.copy();
//        cloudFileSystem.move();
//        cloudFileSystem.upload(true);
//        cloudFileSystem.upload();


        GoogleDrive googleDrive = new GoogleDrive(40, "ABC", "File", 20000, true, false, 0);
        googleDrive.copy();
        googleDrive.upload(true);
        googleDrive.isConnectionAvailable = false;
    }
}
