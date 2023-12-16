package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ObjectNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> movieOptional = movieRepository.findById(id);
		Movie movie = movieOptional
				.orElseThrow(
					() -> new ObjectNotFoundException("Filme não encontrado / Movie not found")
				);
		return new MovieDTO(movie, movie.getReviews());
	}
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable){
		List<Genre> genres = (genreId == 0) ? genreRepository.findAll() : Arrays.asList(genreRepository.getOne(genreId));
		Page<Movie> movies = movieRepository.findByGenre(genres, pageable);
		
		return movies.map(mov -> new MovieDTO(mov));
	}
		
}
