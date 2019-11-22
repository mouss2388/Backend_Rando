package com.formation.randoFriends.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.randoFriends.metier.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
