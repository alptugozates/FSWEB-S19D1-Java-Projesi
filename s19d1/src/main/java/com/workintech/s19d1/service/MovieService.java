package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(Long id);
    Movie saveMovie(Movie movie);
    void deleteMovie(Long id);
    Movie updateMovie(Long id, Movie newMovie);
}
