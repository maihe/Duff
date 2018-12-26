package com.ciclic.duff.repo;

import com.ciclic.duff.domain.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Integer> {
    boolean existsByStyle(String style);
}
