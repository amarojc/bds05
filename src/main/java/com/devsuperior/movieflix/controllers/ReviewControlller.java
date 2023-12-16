package com.devsuperior.movieflix.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewControlller {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<ReviewDTO> insertReview(@RequestBody @Valid ReviewDTO reviewDTO){
		reviewDTO = reviewService.insertReview(reviewDTO);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(reviewDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(reviewDTO);
	}
}
