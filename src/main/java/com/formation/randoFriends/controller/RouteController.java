package com.formation.randoFriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.randoFriends.metier.Route;
import com.formation.randoFriends.repositories.RouteRepository;

@RestController
@RequestMapping("/randonneeDetail")
@CrossOrigin

public class RouteController {
	
	@Autowired
	private RouteRepository routeRepository;
	
	@GetMapping
	public Page<Route> findAll(@PageableDefault(page = 0, size = 8) Pageable page){
		return routeRepository.findAll(page);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Route> createRoute(
			@RequestBody Route route){
		route = routeRepository.save(route);
		return new ResponseEntity<Route>(route, HttpStatus.CREATED);
	}
	

}
