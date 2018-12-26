package com.ciclic.duff.service;

import com.ciclic.duff.domain.Beer;
import com.ciclic.duff.domain.TemperatureRange;
import com.ciclic.duff.repo.BeerRepository;
import com.ciclic.duff.repo.TemperatureRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private BeerRepository beerRepository;
    private TemperatureRangeRepository rangeRepository;


    @Autowired
    public BeerService(BeerRepository beerRepository, TemperatureRangeRepository rangeRepository) {
        this.beerRepository = beerRepository;
        this.rangeRepository = rangeRepository;
    }

    public Beer createBeer(Beer newBeer) {
        Beer beer = null;
        if (!beerRepository.existsByStyle(newBeer.getStyle())) {
            TemperatureRange range = persistRange(newBeer);
            newBeer.setRange(range);
            beer = beerRepository.save(newBeer);
        }
        return beer;
    }

    private TemperatureRange persistRange(Beer newBeer) {
        TemperatureRange range = rangeRepository.findByMinAndMax(newBeer.getRange().getMin(), newBeer.getRange().getMax());
        if (null == range) {
            range = new TemperatureRange(newBeer.getRange().getMin(), newBeer.getRange().getMax());
            range = rangeRepository.save(range);
        }
        return range;
    }

    public Iterable<Beer> lookup() {
        return beerRepository.findAll();
    }

    public Beer getTheBestBeer(int temperature) {
        Iterable<Beer> beerIterable = lookup();
        List<Beer> beers = (List<Beer>) beerIterable;
        int minDiff = beers
                .stream()
                .mapToInt(b -> distance(temperature, b.getRange().getMedia()))
                .min()
                .orElse(-1);

        return beers
                .stream()
                .filter(x -> distance(temperature, x.getRange().getMedia()) == minDiff)
                .sorted(Comparator.comparing(Beer::getStyle))
                .collect(Collectors.toList()).get(0);
    }


    private int distance(int temperature, int media) {
        return Math.abs(media - temperature);
    }
}
