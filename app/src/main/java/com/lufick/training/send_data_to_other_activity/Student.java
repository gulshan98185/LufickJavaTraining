package com.lufick.training.send_data_to_other_activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    String name;
    String address;
    int age;
    String city;
    String country;

    School school;

    public Student(String name, String address, int age, String city, String country, School school){
        this.name = name;
        this.address = address;
        this.age = age;
        this.city = city;
        this.country = country;
        this.school = school;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeInt(this.age);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeParcelable(this.school, flags);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.address = source.readString();
        this.age = source.readInt();
        this.city = source.readString();
        this.country = source.readString();
        this.school = source.readParcelable(School.class.getClassLoader());
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.age = in.readInt();
        this.city = in.readString();
        this.country = in.readString();
        this.school = in.readParcelable(School.class.getClassLoader());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
