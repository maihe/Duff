package com.ciclic.duff.controller;

import com.ciclic.duff.domain.Beer;
import com.ciclic.duff.domain.spotify.Playlist;
import com.ciclic.duff.domain.view.BeerResponse;
import com.ciclic.duff.proxy.SpotifyProxy;
import com.ciclic.duff.repo.BeerRepository;
import com.ciclic.duff.service.BeerService;
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
    private final BeerService service;
    private final BeerRepository repository;

    private SpotifyProxy proxy;

    @Autowired
    public DuffController(BeerService service, BeerRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/duff/{temp}")
    // @HystrixCommand(fallbackMethod = "error")
    public ResponseEntity<BeerResponse> getTheBestBeer(@PathVariable Integer temp) {
        Beer beer = service.getTheBestBeer(temp);
        String userID = "";
        String playlistId = "";
        Playlist playlist = proxy.getPlayListValue(userID, playlistId);
        return ResponseEntity.status(HttpStatus.OK).body(new BeerResponse(beer.getStyle(), playlist));
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