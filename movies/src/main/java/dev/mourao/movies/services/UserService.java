package dev.mourao.movies.services;

import dev.mourao.movies.domain.User;
import dev.mourao.movies.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userRepository.findById(id);
    }

    public List<Optional<User>> getByName(String name) {
        return userRepository.findByName(name);
    }

    public User create(User user) {
        return userRepository.insert(user);
    }

    public User update(ObjectId id, String name, String email, String password, String roles) {
        var user = new User(id, name, email, password, roles);
        mongoTemplate.save(user);
        return user;
    }

    public User delete(ObjectId id) {
        var user = getById(id);
        if (user.isPresent()) {
            var users = user.get();
            mongoTemplate.remove(users);
            return users;
        }
        return new User("none", "none", "none", "none");
    }

    public Boolean getThrow() {
        throw new IllegalStateException("Bad operation executed");
    }
}
