package com.ciclic.duff.repo;

import com.ciclic.duff.domain.TemperatureRange;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRangeRepository extends CrudRepository<TemperatureRange, Integer> {
    TemperatureRange findByMinAndMax(int min, int max);
}
