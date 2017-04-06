package com.example.kimja.a5th_homework;

import android.os.Parcel;
import android.os.Parcelable;

public class information implements Parcelable{
    private int telnum = 0;
    private int pic = 0;
    private String menu1 = "";
    private String menu2 = "";
    private String menu3 = "";
    private String homepage = "";
    private String createtime = "";


    protected information(Parcel in) {
        telnum = in.readInt();
        pic = in.readInt();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        homepage = in.readString();
        createtime = in.readString();
    }

    public static final Creator<information> CREATOR = new Creator<information>() {
        @Override
        public information createFromParcel(Parcel in) {
            return new information(in);
        }

        @Override
        public information[] newArray(int size) {
            return new information[size];
        }
    };



    public information(){
        this.telnum = 0;
        this.pic = 0;
        this.menu1 = "";
        this.menu2 = "";
        this.menu3 = "";
        this.homepage = "";
        this.createtime = "";
    }

    public information(int telnum, String menu1, String menu2 , String menu3, String homepage){
        this.telnum = telnum;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.homepage = homepage;
    }

    public int getTelnum() {return this.telnum;}
    public int getPic(){return this.pic;}
    public String getMenu1() {return this.menu1;}
    public String getMenu2() {return this.menu2;}
    public String getMenu3() {return this.menu3;}
    public String getHomepage() {return this.homepage;}
    public String getCreatetime(){return this.createtime;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(telnum);
        dest.writeInt(pic);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(homepage);
        dest.writeString(createtime);
    }
}
