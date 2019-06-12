package cn.artaris.androidknowledge.AIDL.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * cn.artaris.aidldemo
 * AIDLDemo
 * 2018.11.19.00:24
 *
 * @author : artairs
 */
public class Person implements Parcelable {

    private String mName;

    public String getName() {
        return mName;
    }

    public Person(String name) {
        mName = name;
    }

    protected Person(Parcel in) {
        mName = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }
}
