package com.example.MovieManagementApp.controller;

import com.example.MovieManagementApp.entity.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private Map<Long, Movie>movieMap=new HashMap<>();

    @GetMapping

    public List <Movie> getMovie(){

        return new ArrayList<>(movieMap.values());
    }
    @PostMapping
    public String createMovie(@RequestBody Movie movie) {
        movieMap.put(movie.getId(), movie); // Store the movie in the map using its ID
        return "Movie added successfully!";
    }

    @GetMapping("/{id}")

    public Movie  getMovieById(@PathVariable long id){

        return movieMap.get(id);
    }
    @PutMapping("/{id}")

    public String update(@PathVariable long id,@RequestBody Movie movie){
        movieMap.put(id,movie);
        return" movie Updated Sucessfully";
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable long id){

        movieMap.remove(id);
        return"Delete Movie sucessfully";
    }




}
