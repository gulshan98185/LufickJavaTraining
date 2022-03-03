package com.lufick.java_lib;

import java.io.File;

public class CoreJavaLibrary {
    public static void main(String args[]) {
        System.out.println("Hello World");


        FileSystem fileSystem = getFileSystem(1);
        fileSystem.upload("storage/emulated/0/abc.jpg");
        fileSystem.delete("storage/emulated/0/abc.jpg");
        fileSystem.getAvlStorage();
    }

    public static FileSystem getFileSystem(int userSelection) {
        if (userSelection == 1) {
            return new GoogleDriveFileSystem();
        } else if (userSelection == 2) {
            return new DropBoxFileSystem();
        } else if (userSelection == 3) {
            return new OneDriveFileSystem();
        } else {
            throw new RuntimeException("File System not found");
        }
    }
}


class FileSystem {
    public void upload(String path) {
        System.out.println("File system common file upload code");
    }

    public void delete(String path) {
        //common delete code
    }

    public int getAvlStorage() {
        return 0;
    }
}

class GoogleDriveFileSystem extends FileSystem {
    @Override
    public void upload(String path) {
        System.out.println("Google drive file upload code");
    }

    @Override
    public int getAvlStorage() {
        return 101;//Return storage
        //return super.getAvlStorage();
    }
}

class DropBoxFileSystem extends FileSystem {
    @Override
    public void upload(String path) {
        System.out.println("Dropbox File upload code");
    }

    @Override
    public int getAvlStorage() {
        return 0;
    }
}

class OneDriveFileSystem extends FileSystem {
    @Override
    public void upload(String path) {
        //super.upload(path);
        System.out.println("Onedrive file upload system");
    }

    @Override
    public void delete(String path) {
        super.delete(path);
        //some extra code run
        //diff one drive delete logic
    }
}