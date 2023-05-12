package dev.mourao.movies.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@DataJpaTest
public class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    @Disabled
    void testfindByName() {
        User actualUser = new User("Name", "jane.doe@example.org", "pass123", "Role");

        userJpaRepository.save(actualUser);

        var expected = Objects.nonNull(userJpaRepository.selectExistsEmail(actualUser.getEmail()));

        assertThat(expected).isTrue();
    }
}


