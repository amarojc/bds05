package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório!")
	private String title;
	private String subTitle;
	private String synopsis;
	private Integer year;
	private String imgUrl;
	private Long genreId;
	
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, String subTitle, String synopsis, Integer year, String imgUrl, Long genreId) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.synopsis = synopsis;
		this.year = year;
		this.imgUrl = imgUrl;
		this.genreId = genreId;
	}
	
	public MovieDTO(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		subTitle = movie.getSubTitle();
		synopsis = movie.getSynopsis();
		year = movie.getYear();
		imgUrl = movie.getImgUrl();
		genreId = movie.getGenre().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	
	
}
