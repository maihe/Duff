package com.ciclic.duff.controller;

import com.ciclic.duff.domain.Beer;
import com.ciclic.duff.domain.spotify.DuffPlaylist;
import com.ciclic.duff.domain.view.BeerResponse;
import com.ciclic.duff.service.BeerService;
import com.ciclic.duff.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = {"/", "/home"})
public class DuffController {

    private static final Logger LOGGER = Logger.getLogger(DuffController.class.getName());
    private final BeerService beerService;
    private final SpotifyService spotifyService;

    @Autowired
    public DuffController(BeerService beerService, SpotifyService spotifyService) {
        this.beerService = beerService;
        this.spotifyService = spotifyService;
    }

    @GetMapping({"/", "/duff"})
    public String home() {
        return "Welcome to Duff Beer and Playlist selector! " +
                "Go to /duff/{TEMPERATURE} to try it! or read https://github.com/maihe/Duff/blob/master/README.md";
    }

    @GetMapping("/duff/{temp}")
    // @HystrixCommand(fallbackMethod = "error")
    public ResponseEntity<BeerResponse> getHarmonization(@PathVariable Integer temp) {
        LOGGER.info("Get Harmonization");
        ResponseEntity<BeerResponse> response;
        Beer beer = beerService.getTheBestBeer(temp);
        DuffPlaylist duffPlaylist = spotifyService.getDuffPlaylist(beer.getStyle());
        BeerResponse beerResponse = new BeerResponse(beer.getStyle(), duffPlaylist);
        LOGGER.info(beerResponse.toString());
        if (duffPlaylist != null) {
            response = ResponseEntity.status(HttpStatus.OK).body(beerResponse);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(beerResponse);
        }
        return response;
    }

    public ResponseEntity<BeerResponse> error(Integer value) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BeerResponse("error", null));
    }

//    @PostMapping("/duffs/new")
//    public String save(Model model, @ModelAttribute("beer") Beer beer) {
//        LOGGER.info("Save ");
//        return "save";
//    }
//
//    @PutMapping("/duffs/update")
//    public String update(Model model, @ModelAttribute("beer") Beer beer) {
//        LOGGER.info("Update ");
//        return "update";
//    }
//
//    @GetMapping("/duffs/get")
//    public String get(Model model, @ModelAttribute("beer") Beer beer) {
//        LOGGER.info("Get ");
//        return "get";
//    }
//
//    @GetMapping("/duffs/delete")
//    public String delete(Model model, @ModelAttribute("beer") Beer beer) {
//        LOGGER.info("Delete ");
//        return "delete";
//    }

}