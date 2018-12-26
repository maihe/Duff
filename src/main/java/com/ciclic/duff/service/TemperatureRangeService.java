package com.ciclic.duff.service;

import com.ciclic.duff.domain.TemperatureRange;
import com.ciclic.duff.repo.TemperatureRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureRangeService {

    private TemperatureRangeRepository TemperatureRangeRepository;

    @Autowired
    public TemperatureRangeService(TemperatureRangeRepository TemperatureRangeRepository) {
        this.TemperatureRangeRepository = TemperatureRangeRepository;
    }

    public TemperatureRange createTemperatureRange(TemperatureRange newTemperatureRange) {
        TemperatureRange range = null;
        range = TemperatureRangeRepository.save(newTemperatureRange);

        return range;
    }

    public Iterable<TemperatureRange> lookup() {
        return TemperatureRangeRepository.findAll();
    }

}
