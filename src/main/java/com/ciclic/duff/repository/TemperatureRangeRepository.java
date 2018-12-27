package com.ciclic.duff.repository;

import com.ciclic.duff.domain.crud.TemperatureRange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface TemperatureRangeRepository extends CrudRepository<TemperatureRange, Integer> {
    TemperatureRange findByMinAndMax(int min, int max);
}
