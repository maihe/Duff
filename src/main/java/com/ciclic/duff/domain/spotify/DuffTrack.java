package com.ciclic.duff.domain.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DuffTrack {
    private String name;
    private String artist;
    @JsonProperty("link")
    private String href;

    public DuffTrack(String name, String artist, String href) {
        this.name = name;
        this.artist = artist;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "DuffTrack{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}