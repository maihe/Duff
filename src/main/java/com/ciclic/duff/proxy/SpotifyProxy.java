package com.ciclic.duff.proxy;

import com.ciclic.duff.domain.spotify.DuffPlaylist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "zuul")
public interface SpotifyProxy {

    @GetMapping("/playlist/playlist/userid/{userId}/playlistid/{playlistId}")
    DuffPlaylist getPlayListValue(@PathVariable("userId") String userId, @PathVariable("playlistId") String playlistId);
}
