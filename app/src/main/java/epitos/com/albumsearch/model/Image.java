package epitos.com.albumsearch.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    private String text;

    public String getText() { return this.text; }

    public void setText(String text) { this.text = text; }

    private String size;

    public String getSize() { return this.size; }

    public void setSize(String size) { this.size = size; }
}
