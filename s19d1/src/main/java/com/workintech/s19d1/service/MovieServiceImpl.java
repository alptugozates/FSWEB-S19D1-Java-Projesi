package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements  MovieService{
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
    }
    @Override
    public Movie updateMovie(Long id, Movie newMovieData) {
        Optional<Movie> existingMovieOptional = movieRepository.findById(id);

        existingMovieOptional.isPresent();
            Movie existingMovie = existingMovieOptional.get();

            existingMovie.setName(newMovieData.getName());
            existingMovie.setDirectorName(newMovieData.getDirectorName());
            existingMovie.setRating(newMovieData.getRating());
            existingMovie.setReleaseDate(newMovieData.getReleaseDate());
            existingMovie.setActors(newMovieData.getActors());

            return movieRepository.save(existingMovie);
        }




}
