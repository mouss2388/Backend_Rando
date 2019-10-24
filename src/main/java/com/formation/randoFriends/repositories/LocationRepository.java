package com.formation.randoFriends.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.randoFriends.metier.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, Integer> {

}
