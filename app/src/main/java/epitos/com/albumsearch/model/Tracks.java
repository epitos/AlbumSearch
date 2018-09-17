package epitos.com.albumsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tracks implements Parcelable {

    private Track track;

    protected Tracks(Parcel in) {
    }

    public static final Creator<Tracks> CREATOR = new Creator<Tracks>() {
        @Override
        public Tracks createFromParcel(Parcel in) {
            return new Tracks(in);
        }

        @Override
        public Tracks[] newArray(int size) {
            return new Tracks[size];
        }
    };

    public Track getTrack() { return this.track; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
