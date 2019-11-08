package com.formation.randoFriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.randoFriends.metier.Trek;
import com.formation.randoFriends.repositories.TrekRepository;

@Controller
@RequestMapping("/accueil")
@CrossOrigin("http://localhost:4200")
public class TrekController {
	
	@Autowired
	private TrekRepository trekRepository;
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Page<Trek> findAll(@PageableDefault(page = 2, size = 1) Pageable page){
		return trekRepository.findAll(page);
	}
	
	
	@PostMapping(value="/insert",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Trek> createTrek(
			@RequestBody Trek trek){
		trek = trekRepository.save(trek);
		return new ResponseEntity<Trek>(trek, HttpStatus.CREATED);
	}
	

}
