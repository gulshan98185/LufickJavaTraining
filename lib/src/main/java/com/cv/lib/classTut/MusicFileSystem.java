package com.cv.lib.classTut;

public class MusicFileSystem extends MediaFileSystem{
    MusicFileSystem() {
        super(500, "XYZ", "Folder", 1200);
    }

    public void play(){
        String name = getName();
        type = "File";
        //name = "XYZ";
    }

    @Override
    public void copy() {

    }

    @Override
    public void move() {

    }

    @Override
    public void share() {

    }
}
