package dev.mourao.movies.services;

import dev.mourao.movies.domain.Movie;
import dev.mourao.movies.domain.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getById(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> getByImdbId(String id) {
        return movieRepository.findByImdbId(id);
    }
}
