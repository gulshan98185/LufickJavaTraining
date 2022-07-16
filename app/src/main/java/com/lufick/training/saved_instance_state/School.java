package com.lufick.training.saved_instance_state;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class School implements Parcelable {
    String name;
    String address;
    int noOfStudent;
    Student student;

    public School(String name, String address, int noOfStudent, Student student) {
        this.name = name;
        this.address = address;
        this.noOfStudent = noOfStudent;
        this.student = student;
    }

    protected School(Parcel in) {
        name = in.readString();
        address = in.readString();
        noOfStudent = in.readInt();
        student = in.readParcelable(Student.class.getClassLoader());
    }

    public static final Creator<School> CREATOR = new Creator<School>() {
        @Override
        public School createFromParcel(Parcel in) {
            return new School(in);
        }

        @Override
        public School[] newArray(int size) {
            return new School[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(noOfStudent);
        dest.writeParcelable(student, flags);
    }
}
