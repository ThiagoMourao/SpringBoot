package dev.mourao.movies.controller;

import dev.mourao.movies.domain.Movie;
import dev.mourao.movies.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(movieService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{iamdbId}")
    public ResponseEntity<Optional<Movie>> getByImdbId(@PathVariable String iamdbId) {
        return new ResponseEntity<>(movieService.getByImdbId(iamdbId), HttpStatus.OK);
    }
}
