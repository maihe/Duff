package com.ciclic.duff.repository;

import com.ciclic.duff.domain.crud.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Integer> {
    boolean existsByStyle(String style);
}
