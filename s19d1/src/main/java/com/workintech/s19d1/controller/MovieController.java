package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getAllMovies(){
    return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id).orElse(null);
    }
    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }


    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.updateMovie(id, movie);
    }


}
