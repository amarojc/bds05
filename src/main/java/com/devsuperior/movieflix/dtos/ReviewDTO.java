package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório!")
	private String text;
	
	@NotNull(message = "Campo obrigatório!")
	private Long movieId;
	
	private UserDTO user;
	
	public ReviewDTO() {
	}
	
	

	public ReviewDTO(Long id, String text) {
		this.id = id;
		this.text = text;
	}


	public ReviewDTO(Review review) {
		id = review.getId() ;
		text = review.getText();
		movieId = review.getMovie().getId();
		user = new UserDTO(review.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
		
}
