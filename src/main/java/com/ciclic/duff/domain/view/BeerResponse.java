package com.ciclic.duff.domain.view;

import com.ciclic.duff.domain.spotify.Playlist;

public class BeerResponse {
    private final String beerStyle;
    private final Playlist playlist;

    public BeerResponse(String beerStyle, Playlist playlist) {
        this.beerStyle = beerStyle;
        this.playlist = playlist;
    }
}
