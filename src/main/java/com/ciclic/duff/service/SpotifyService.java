package com.ciclic.duff.service;

import com.ciclic.duff.domain.spotify.DuffPlaylist;
import com.ciclic.duff.domain.spotify.DuffTrack;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchPlaylistsRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SpotifyService {
    private static final Logger LOGGER = Logger.getLogger(SpotifyService.class.getName());

    private final CountryCode countryCode = CountryCode.BR;
    private final int limit = 1;
    private final int offset = 0;
    private SpotifyApi spotifyApiAuth;

    public SpotifyService() {
        spotifyApiAuth = clientCredentialsSync();
    }


    private SpotifyApi clientCredentialsSync() {
        LOGGER.info("Get Credentials");
        try {
            final String clientId = "4e3fbf449c234e2ea26073a23ccf6cb2";
            final String clientSecret = "4e62dd896b094460b3d5f3bdbcb7d0a5";
            spotifyApiAuth = new SpotifyApi.Builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .build();
            final ClientCredentialsRequest clientCredentialsRequest = spotifyApiAuth.clientCredentials()
                    .build();
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApiAuth.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException e) {
            LOGGER.severe("Error: " + e.getMessage());
        }
        return spotifyApiAuth;
    }

    public DuffPlaylist getDuffPlaylist(String style) {
        LOGGER.info("Get Duff Playlist for " + style);
        Paging<PlaylistSimplified> playlistSimplifiedPaging = searchPlaylistSync(style);
        DuffPlaylist duffPlaylist = null;
        if (playlistSimplifiedPaging != null && playlistSimplifiedPaging.getTotal() > 0) {
            PlaylistSimplified[] items = playlistSimplifiedPaging.getItems();
            if (items.length > 0) {
                duffPlaylist = getPlaylistSync(items[0].getOwner().getId(), items[0].getId());
            }
        }
        return duffPlaylist;
    }

    private Paging<PlaylistSimplified> searchPlaylistSync(String query) {
        LOGGER.info("Search Playlist Sync to " + query);

        SearchPlaylistsRequest searchPlaylistsRequest = spotifyApiAuth.searchPlaylists(query)
                .market(countryCode)
                .limit(limit)
                .offset(offset)
                .build();
        Paging<PlaylistSimplified> playlistSimplifiedPaging = null;
        try {
            playlistSimplifiedPaging = searchPlaylistsRequest.execute();
            LOGGER.info("Total: " + playlistSimplifiedPaging.getTotal());
        } catch (IOException | SpotifyWebApiException e) {
            LOGGER.log(Level.SEVERE, "Error: " + e.getMessage());
        }
        return playlistSimplifiedPaging;
    }

    private DuffPlaylist getPlaylistSync(String userId, String playlistId) {
        LOGGER.log(Level.INFO, "Get Playlist user: " + userId + " ,id: " + playlistId);

        DuffPlaylist myPlaylist = new DuffPlaylist();
        try {

            GetPlaylistRequest getPlaylistRequest = spotifyApiAuth.getPlaylist(userId, playlistId)
                    .market(countryCode)
                    .build();
            final Playlist playlist = getPlaylistRequest.execute();
            myPlaylist.setName(playlist.getName());
            List<DuffTrack> tracks = new ArrayList<>();
            LOGGER.info("Fill tracks...");
            for (PlaylistTrack item : playlist.getTracks().getItems()) {

                tracks.add(new DuffTrack(item.getTrack().getName(),
                        playlist.getTracks().getItems()[0].getTrack().getArtists()[0].getName(),
                        playlist.getTracks().getItems()[0].getTrack().getArtists()[0].getHref()));
            }

            myPlaylist.setDuffTracks(tracks);

        } catch (IOException | SpotifyWebApiException e) {
            LOGGER.log(Level.SEVERE, "Error: " + e.getMessage());
        }
        return myPlaylist;
    }


}
