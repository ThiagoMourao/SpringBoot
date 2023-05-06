package dev.mourao.movies.controller;

import dev.mourao.movies.domain.Review;
import dev.mourao.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.create(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
