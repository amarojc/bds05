package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public ReviewDTO insertReview(ReviewDTO reviewDTO) {
		Review review = new Review();
		copyDtoToEntity(reviewDTO, review);
		review = reviewRepository.save(review);
		
		return new ReviewDTO(review);
	}
	
	private void copyDtoToEntity(ReviewDTO reviewDTO, Review review) {
		review.setText(reviewDTO.getText());
		
		Movie movie = new Movie();
		movie.setId(reviewDTO.getMovieId());
		review.setMovie(movie);
	
		User user = new User();
		user.setId(userService.findByProfileUserLogged().getId());
		user.setName(userService.findByProfileUserLogged().getName());
		user.setEmail(userService.findByProfileUserLogged().getEmail());
		review.setUser(user);
	}
}
