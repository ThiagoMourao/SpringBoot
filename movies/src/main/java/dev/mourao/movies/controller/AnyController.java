package dev.mourao.movies.controller;

import dev.mourao.movies.tools.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/v1/any")
public class AnyController {

    @GetMapping("/bitwiseComparator/{number1}/{number2}")
    public ResponseEntity<Optional<Integer>> bitwiseComparator(@PathVariable Integer number1, @PathVariable Integer number2) {
        return new ResponseEntity<>(Utils.bitwiseComparator(number1, number2), HttpStatus.OK);
    }
}
