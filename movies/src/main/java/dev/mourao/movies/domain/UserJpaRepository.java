package dev.mourao.movies.domain;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, ObjectId> {
    @Query("""
            SELECT
            CASE WHEN COUNT(u) > 0
            THEN TRUE ELSE FALSE
            END
            FROM User u
            WHERE u.email = ?1
            """)
    Boolean selectExistsEmail(String email);
}
