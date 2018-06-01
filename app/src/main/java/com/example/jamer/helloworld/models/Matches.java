package com.example.jamer.helloworld.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Matches implements Parcelable {
    public String uid;
    public String name;
    public String imageUrl;
    public boolean liked;
    public String lat;
    public String longitude;

    public Matches() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Matches(String name, boolean liked, String imageUrl, String latitude, String longitude) {
        this.name = name;
        this.liked = liked;
        this.imageUrl = imageUrl;
        this.longitude = longitude;
        this.lat = lat;
    }

//    public Matches(Parcel in) {
//        name = in.readString();
//        imageUrl = in.readString();
//        liked = in.readByte() != 0;
//        longitude = in.readString();
//        lat = in.readString();
//    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isLiked() {
        return liked;
    }


    public String getLatitude() {
        return lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public static final Creator<Matches> CREATOR = new Creator<Matches>() {
        @Override
        public Matches createFromParcel(Parcel in) {
            return new Matches();
        }

        @Override
        public Matches[] newArray(int size) {
            return new Matches[size];
        }
    };

//    @Exclude
//    public Map<String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("uid", uid);
//        result.put("imageUrl", imageUrl);
//        result.put("liked", liked);
//        result.put("name", name);
//        result.put("lat", lat);
//        result.put("long", longitude);
//
//        return result;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(name);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeString(longitude);
        dest.writeString(lat);
    }
}