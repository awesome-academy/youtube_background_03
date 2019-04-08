package com.sun.youtube_background_03.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {

    private String mId;
    private String mTitle;
    private String mDescription;
    private String mThumbnail;

    public Video() {
    }

    public Video(String ID, String title, String description, String thumbnail) {
        mId = ID;
        mTitle = title;
        mDescription = description;
        mThumbnail = thumbnail;
    }

    public Video(Builder videoBuilder){
        mId = videoBuilder.mId;
        mTitle = videoBuilder.mTitle;
        mThumbnail = videoBuilder.mThumbnail;
        mDescription = videoBuilder.mDescription;
    }

    protected Video(Parcel in) {
        mId = in.readString();
        mTitle = in.readString();
        mDescription = in.readString();
        mThumbnail = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getID() {
        return mId;
    }

    public void setID(String ID) {
        mId = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeString(mThumbnail);
    }

    public static class Builder {

        private String mId;
        private String mTitle;
        private String mDescription;
        private String mThumbnail;
        public Builder() {
        }

        public Video build() {
            return new Video(this);
        }

        public Builder setID(String ID) {
            mId = ID;
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setDescription(String description) {
            mDescription = description;
            return this;
        }

        public Builder setThumbnail(String thumbnail) {
            mThumbnail = thumbnail;
            return this;
        }
    }

    public final class JsonEntity {
        public static final String ITEM = "items";
        public static final String TITLE = "title";
        public static final String SOURCE = "resourceId";
        public static final String ID = "videoId";
        public static final String DESCRIPTION = "description";
        public static final String THUMBNAIL = "thumbnails";
    }
}
