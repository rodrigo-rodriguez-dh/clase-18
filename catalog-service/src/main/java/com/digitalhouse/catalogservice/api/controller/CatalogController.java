package com.digitalhouse.catalogservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhouse.catalogservice.api.service.MovieService;
import com.digitalhouse.catalogservice.domain.model.MovieDTO;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final MovieService movieService;

    @Autowired
    public CatalogController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<MovieDTO>> getGenre(@PathVariable String genre) {
        return movieService.findMovieByGenre(genre);
    }

    @GetMapping("/withErrors/{genre}")
    ResponseEntity<List<MovieDTO>> getGenre(@PathVariable String genre, @RequestParam("throwError") Boolean throwError) {
        return movieService.findMovieByGenre(genre, throwError);
    }

    @PostMapping
    ResponseEntity<String> saveMovie(@RequestBody MovieDTO movieDTO) {
        movieService.saveMovie(movieDTO);
        return ResponseEntity.ok("La pelicula fue creada");
    }
}
