package com.ciclic.duff.domain.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DuffPlaylist {

    private String name;
    @JsonProperty("tracks")
    private List<DuffTrack> duffTracks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DuffTrack> getDuffTracks() {
        return duffTracks;
    }

    public void setDuffTracks(List<DuffTrack> duffTracks) {
        this.duffTracks = duffTracks;
    }

    @Override
    public String toString() {
        return "DuffPlaylist{" +
                "name='" + name + '\'' +
                ", duffTracks=" + duffTracks +
                '}';
    }
}