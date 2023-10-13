package com.example.peopleapp.people;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    private final String name;
    private final int age;
    private final String city;
    private final String address;

    public People(String name, int age, String city, String address) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.address = address;
    }

    protected People(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        city = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
        dest.writeString(city);
    }
}
