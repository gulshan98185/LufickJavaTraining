package com.lufick.training.send_data_to_other_activity;

import android.os.Parcel;
import android.os.Parcelable;

public class School implements Parcelable {
    String schoolName;
    String schoolAddress;

    public School(String schoolName, String schoolAddress) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.schoolName);
        dest.writeString(this.schoolAddress);
    }

    public void readFromParcel(Parcel source) {
        this.schoolName = source.readString();
        this.schoolAddress = source.readString();
    }

    protected School(Parcel in) {
        this.schoolName = in.readString();
        this.schoolAddress = in.readString();
    }

    public static final Parcelable.Creator<School> CREATOR = new Parcelable.Creator<School>() {
        @Override
        public School createFromParcel(Parcel source) {
            return new School(source);
        }

        @Override
        public School[] newArray(int size) {
            return new School[size];
        }
    };
}
