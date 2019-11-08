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

import com.formation.randoFriends.metier.Location;
import com.formation.randoFriends.repositories.LocationRepository;

@Controller
@RequestMapping("/liste")
@CrossOrigin("http://localhost:4200")
public class LoctionController {
	@Autowired
	private LocationRepository routeRepository;



	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Page<Location> findAll(@PageableDefault(page = 0, size = 8) Pageable page){
		return routeRepository.findAll(page);
	}

	@PostMapping(value="/insert",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Location> createProduit(
			@RequestBody Location location)
	{
		/*if (produit.getId() != 0 || categorieId == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Optional<Categorie> cat = categorieRepository.findById(categorieId);
		if (!cat.isPresent())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 */
		//produit.setCategorie(cat.get());
		location = routeRepository.save(location);
		return new ResponseEntity<Location>(location, HttpStatus.CREATED);
	}

}

