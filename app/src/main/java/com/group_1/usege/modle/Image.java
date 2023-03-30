package com.group_1.usege.modle;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Image implements Parcelable {
    private String date;
    private long size;
    private String description;
    private String location;
    private Uri uri;

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        // neu location o dang toa do thi goi api de chuyen doi
        // nguoc lai khong lam gi
        this.location = location;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image() {
        // Nothing
    }

    public Image(String date, long size, String description, String location, Uri uri) {
        this.date = date;
        this.size = size;
        this.description = description;
        this.location = location;
        this.uri = uri;
    }

    protected Image(Parcel in) {
        date = in.readString();
        size = in.readLong();
        description = in.readString();
        location = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeFloat(size);
        dest.writeString(description);
        dest.writeString(location);
        dest.writeParcelable(uri, flags);
    }
}
