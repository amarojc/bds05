package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query("SELECT movie FROM Movie movie "
			+ "WHERE movie.genre IN :genres "
			+ "ORDER BY movie.title ASC")
	Page<Movie> findByGenre(List<Genre> genres, Pageable pageable);
	
}
