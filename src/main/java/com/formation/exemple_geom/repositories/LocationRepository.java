package com.formation.exemple_geom.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.exemple_geom.metier.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, Integer> {

}
