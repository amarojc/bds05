package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(movieService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> find(
				@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
				Pageable pageable){
		Page<MovieDTO> movies = movieService.findByGenre(genreId, pageable);
		return ResponseEntity.ok().body(movies);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<MovieDTO> findByIdAllReviews(@PathVariable Long id){
		return ResponseEntity.ok().body(movieService.findById(id));
	}
}
