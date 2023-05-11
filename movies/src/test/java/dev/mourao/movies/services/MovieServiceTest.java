package dev.mourao.movies.services;

import dev.mourao.movies.domain.MovieRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;
    @Autowired
    private MovieService movieService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        movieService = new MovieService(movieRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetAll() {
        movieService.getAll();
        verify(movieRepository).findAll();
    }

    @Test
    void testGetById() {
        var id = ObjectId.get();
        movieService.getById(id);
        verify(movieRepository).findById(id);
    }

    @Test
    void testGetByImdbId() {
        var imdbId = "42";
        movieService.getByImdbId(imdbId);
        verify(movieRepository).findByImdbId(imdbId);
    }
}

