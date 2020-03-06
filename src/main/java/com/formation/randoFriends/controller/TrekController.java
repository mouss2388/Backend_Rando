package com.formation.randoFriends.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.formation.randoFriends.metier.Trek;
import com.formation.randoFriends.repositories.TrekRepository;

@RestController
@RequestMapping("/treks")
@CrossOrigin
public class TrekController {

	@Autowired
	private TrekRepository trekRepository;

	@GetMapping
	public Page<Trek> findAll(@PageableDefault(page = 0, size = 1) Pageable page){
		return trekRepository.findAll(page);
	}

	@GetMapping("/{id:[0-9]+}")
	public Trek findAll(@PathVariable int id){

		Optional<Trek> trek = trekRepository.findById(id);

		if(!trek.isPresent())throw new ResourceAccessException("Undefined trek for id :" + id);

		return trek.get();
	}

	@DeleteMapping("/{id:[0-9]+}")
	public ResponseEntity deleteTrek(@PathVariable("id") int id) {
		Optional<Trek> otrek = trekRepository.findById(id);
		if (!otrek.isPresent())throw new ResourceAccessException("Undefined trek for id :" + id);
		
//		trek.getImages().clear();
		// effacement produit
		trekRepository.deleteById(id);
		return new ResponseEntity<>("Delete trek with id :" + id, HttpStatus.ACCEPTED);
	}


	@PostMapping
	public ResponseEntity<Trek> createTrek(
			@RequestBody Trek trek){
		trek = trekRepository.save(trek);
		return new ResponseEntity<Trek>(trek, HttpStatus.CREATED);
	}


}
