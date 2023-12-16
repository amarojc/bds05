package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;



@Controller
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAllGenres(){
		return ResponseEntity.ok().body(genreService.findAllGenres());
	}
}
