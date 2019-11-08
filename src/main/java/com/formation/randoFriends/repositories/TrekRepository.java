package com.formation.randoFriends.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.randoFriends.metier.Trek;

public interface TrekRepository extends PagingAndSortingRepository<Trek,Integer> {

}
