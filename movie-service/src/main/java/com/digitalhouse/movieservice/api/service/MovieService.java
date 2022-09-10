package com.digitalhouse.movieservice.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.digitalhouse.movieservice.domain.models.Movie;
import com.digitalhouse.movieservice.domain.repositories.MovieRepository;

@Service
public class MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    public List<Movie> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    public List<Movie> findByGenre(String genre, Boolean throwError) {
        if (throwError)
            throw new RuntimeException();
        return repository.findByGenre(genre);
    }

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void save(Movie movie) {
        LOG.info("Se recibió una pelicula: "+ movie.toString());
        repository.save(movie);
    }
}
