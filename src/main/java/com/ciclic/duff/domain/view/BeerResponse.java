package com.ciclic.duff.domain.view;

import com.ciclic.duff.domain.spotify.DuffPlaylist;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerResponse {
    private final String beerStyle;
    @JsonProperty("playlist")
    private final DuffPlaylist duffPlaylist;

    public BeerResponse(String beerStyle, DuffPlaylist duffPlaylist) {
        this.beerStyle = beerStyle;
        this.duffPlaylist = duffPlaylist;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public DuffPlaylist getDuffPlaylist() {
        return duffPlaylist;
    }

    @Override
    public String toString() {
        return "BeerResponse{" +
                "beerStyle='" + beerStyle + '\'' +
                ", duffPlaylist=" + duffPlaylist +
                '}';
    }
}
