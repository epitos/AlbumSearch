package epitos.com.albumsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Album implements Parcelable {

    private String name;

    protected Album(Parcel in) {
        name = in.readString();
        artist = in.readString();
        url = in.readString();
        streamable = in.readString();
        mbid = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String artist;

    public String getArtist() { return this.artist; }

    public void setArtist(String artist) { this.artist = artist; }

    private String url;

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    private ArrayList<Image> image;

    public ArrayList<Image> getImage() { return this.image; }

    public void setImage(ArrayList<Image> image) { this.image = image; }

    private String streamable;

    public String getStreamable() { return this.streamable; }

    public void setStreamable(String streamable) { this.streamable = streamable; }

    private String mbid;

    public String getMbid() { return this.mbid; }

    public void setMbid(String mbid) { this.mbid = mbid; }

    private Tracks tracks;

    public Tracks getTracks() { return this.tracks; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(artist);
        dest.writeString(url);
        dest.writeString(streamable);
        dest.writeString(mbid);
    }
}
