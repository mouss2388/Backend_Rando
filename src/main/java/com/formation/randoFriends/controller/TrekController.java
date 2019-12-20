package com.formation.randoFriends.controller;

import java.util.Collections;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;

import com.formation.randoFriends.metier.Image;
import com.formation.randoFriends.metier.Trek;
import com.formation.randoFriends.repositories.TrekRepository;

@Controller
@RequestMapping("/treks")
@CrossOrigin("http://localhost:4200")
public class TrekController {

	@Autowired
	private TrekRepository trekRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Page<Trek> findAll(@PageableDefault(page = 0, size = 1) Pageable page){
		return trekRepository.findAll(page);
	}

	@GetMapping(value="/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Trek findAll(@PathVariable int id){

		Optional<Trek> trek = trekRepository.findById(id);

		if(!trek.isPresent())throw new ResourceAccessException("Undefined trek for id :" + id);

		return trek.get();
	}

	@DeleteMapping(value="/{id:[0-9]+}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity deleteTrek(@PathVariable("id") int id) {
		Optional<Trek> otrek = trekRepository.findById(id);
		if (!otrek.isPresent())throw new ResourceAccessException("Undefined trek for id :" + id);
		
//		trek.getImages().clear();
		// effacement produit
		trekRepository.deleteById(id);
		return new ResponseEntity<>("Delete trek with id :" + id, HttpStatus.ACCEPTED);
	}


	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Trek> createTrek(
			@RequestBody Trek trek){
		trek = trekRepository.save(trek);
		return new ResponseEntity<Trek>(trek, HttpStatus.CREATED);
	}


}
