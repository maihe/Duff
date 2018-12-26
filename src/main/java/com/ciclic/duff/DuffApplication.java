package com.ciclic.duff;

import com.ciclic.duff.domain.Beer;
import com.ciclic.duff.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DuffApplication implements CommandLineRunner {

    private final BeerService beerService;

    @Autowired
    public DuffApplication(BeerService beerService) {
        this.beerService = beerService;
    }


    public static void main(String[] args) {
        SpringApplication.run(DuffApplication.class, args);
    }

    @Override
    public void run(String... args) {
        startUpBeers();

    }

    private void startUpBeers() {
        beerService.createBeer(new Beer("Weissbier", -1, 3));
        beerService.createBeer(new Beer("Pilsens", -2, 4));
        beerService.createBeer(new Beer("Weizenbier", -4, 6));
        beerService.createBeer(new Beer("Red ale", -5, 5));
        beerService.createBeer(new Beer("India pale ale", -6, 7));
        beerService.createBeer(new Beer("IPA", -7, 10));
        beerService.createBeer(new Beer("Dunkel", -8, 2));
        beerService.createBeer(new Beer("Imperial Stouts", -10, 13));
        beerService.createBeer(new Beer("Brown ale", 0, 14));

        beerService.lookup().forEach(beer -> System.out.println(beer.toString()));
    }
}

