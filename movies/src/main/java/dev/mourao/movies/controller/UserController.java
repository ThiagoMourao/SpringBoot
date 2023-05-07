package dev.mourao.movies.controller;

import dev.mourao.movies.domain.User;
import dev.mourao.movies.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Optional<User>>> getByImdbId(@PathVariable String name) {
        return new ResponseEntity<>(userService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> create(@RequestBody Map<String, String> user) {
        return new ResponseEntity<>(userService.create(user.get("name"), user.get("email"), user.get("password"), user.get("role")), HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> update(@PathVariable ObjectId id, @RequestBody Map<String, String> user) {
        return new ResponseEntity<>(userService.update(id, user.get("name"), user.get("email"), user.get("password"), user.get("role")), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable ObjectId id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/test")
    public GreetResponse getTest() {
        return new GreetResponse("Hello", List.of("Java", "Python"), new Person("Pedro"));
    }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person){

    }
    record Person(String name){
    }
}
