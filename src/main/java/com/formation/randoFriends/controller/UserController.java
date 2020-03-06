package com.formation.randoFriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.randoFriends.metier.User;
import com.formation.randoFriends.repositories.UserRepository;

@RestController
@RequestMapping("/list-user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public Page<User> findAll(@PageableDefault(page = 2, size = 1) Pageable page){
		return userRepository.findAll(page);
	}

}
