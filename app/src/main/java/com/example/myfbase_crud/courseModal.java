package com.example.myfbase_crud;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class courseModal {
    private String coursename;
    private String coursedesp;
    private String courseprice;
    private String coursesuite;
    private String imglink;
    private String courselink;
    private String courseID;

    public courseModal(String coursename, String coursedesp, String courseprice, String coursesuite, String imglink, String courselink, String courseID) {
        this.coursename = coursename;
        this.coursedesp = coursedesp;
        this.courseprice = courseprice;
        this.coursesuite = coursesuite;
        this.imglink = imglink;
        this.courselink = courselink;
        this.courseID = courseID + " hello ";
    }

//    protected courseModal(Parcel in) {
//        coursename = in.readString();
//        coursedesp = in.readString();
//        courseprice = in.readString();
//        coursesuite = in.readString();
//        imglink = in.readString();
//        courselink = in.readString();
//        courseID = in.readString();
//    }

//    public static final Creator<courseModal> CREATOR = new Creator<courseModal>() {
//        @Override
//        public courseModal createFromParcel(Parcel in) {
//            return new courseModal(in);
//        }
//
//        @Override
//        public courseModal[] newArray(int size) {
//            return new courseModal[size];
//        }
//    };

    public String getCoursename() {
        return coursename;
    }

    public String getCoursedesp() {
        return coursedesp;
    }

    public String getCourseprice() {
        return courseprice;
    }

    public String getCoursesuite() {
        return coursesuite;
    }

    public String getImglink() {
        return imglink;
    }

    public String getCourselink() {
        return courselink;
    }

    public String getCourseID() {
        return courseID;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeString(coursename);
//        dest.writeString(coursedesp);
//        dest.writeString(courseprice);
//        dest.writeString(coursesuite);
//        dest.writeString(imglink);
//        dest.writeString(courselink);
//        dest.writeString(courseID);
//    }
}
