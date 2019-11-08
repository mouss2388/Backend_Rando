package com.formation.randoFriends.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.randoFriends.metier.Image;


public interface ImageRepository 
		extends PagingAndSortingRepository<Image, Integer>,
				ImageRepositoryCustom {

}
