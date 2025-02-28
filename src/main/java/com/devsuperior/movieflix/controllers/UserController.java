package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.UserRoleDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/profile")
	public ResponseEntity<UserRoleDTO> findByProfileUserLogged(){
		UserRoleDTO userRoleDTO = userService.findByProfileUserLogged();
		return ResponseEntity.ok().body(userRoleDTO);
	}
}
