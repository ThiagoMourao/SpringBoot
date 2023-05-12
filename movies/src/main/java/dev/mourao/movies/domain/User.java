package dev.mourao.movies.domain;

import jakarta.persistence.Entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
