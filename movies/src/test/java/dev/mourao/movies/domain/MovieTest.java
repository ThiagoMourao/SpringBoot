package dev.mourao.movies.domain;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private static Movie movie;

    @BeforeAll
    static void beforeAll() {
        ObjectId id = ObjectId.get();
        var genres = new ArrayList<String>();
        var backdrops = new ArrayList<String>();
        var reviewIds = new ArrayList<Review>();
        movie = new Movie(id, "42", "Dr", "2020-03-01", "Trailer Link", "Poster", genres, backdrops, reviewIds);
    }

    @Test
    void test_constructor() {
        assertEquals("42", movie.getImdbId());
        assertNotEquals("43", movie.getImdbId());
        assertNotEquals("10", movie.getImdbId());

        assertEquals("Dr", movie.getTitle());
        assertNotEquals("Dr.", movie.getTitle());
        assertNotEquals("Mr.", movie.getTitle());

        assertEquals("2020-03-01", movie.getReleaseDate());
        assertNotEquals("2023-03-01", movie.getReleaseDate());
        assertNotEquals("2022-03-01", movie.getReleaseDate());

        assertEquals("Poster", movie.getPoster());
        assertNotEquals("Posters", movie.getPoster());
        assertNotEquals("NPoster", movie.getPoster());

        assertTrue(movie.getGenres() instanceof ArrayList<String>);
        assertFalse(movie.getGenres() instanceof Set<?>);
        assertFalse(movie.getGenres() instanceof Map<?, ?>);

        assertTrue(movie.getBackdrops() instanceof ArrayList<String>);
        assertFalse(movie.getBackdrops() instanceof Set<?>);
        assertFalse(movie.getBackdrops() instanceof Map<?, ?>);

        assertTrue(movie.getReviewIds() instanceof ArrayList<Review>);
        assertFalse(movie.getReviewIds() instanceof Set<?>);
        assertFalse(movie.getReviewIds() instanceof Map<?, ?>);
    }

    @Test
    void test_not_equals_null() {
        assertNotEquals(null, movie);
    }

    @Test
    void test_equals_hashcode() {
        assertEquals(movie, movie);
        int expectedHashCodeResult = movie.hashCode();
        assertEquals(expectedHashCodeResult, movie.hashCode());
    }

    @Test
    void test_equal_movies_content() {
        var movie2 = new Movie();
        movie2.setBackdrops(new ArrayList<>());
        movie2.setGenres(new ArrayList<>());
        movie2.setId(ObjectId.get());
        movie2.setImdbId("42");
        movie2.setPoster("Poster");
        movie2.setReleaseDate("2020-03-01");
        movie2.setReviewIds(new ArrayList<>());
        movie2.setTitle("Dr");
        movie2.setTrailerLink("Trailer Link");
        assertTrue(movie.canEqual(movie2));
    }

    @Test
    void test_different_objects_same_type() {
        var movie2 = new Movie();
        movie2.setBackdrops(new ArrayList<>());
        movie2.setGenres(new ArrayList<>());
        movie2.setId(ObjectId.get());
        movie2.setImdbId("45");
        movie2.setPoster("Mc");
        movie2.setReleaseDate("2022-03-01");
        movie2.setReviewIds(new ArrayList<>());
        movie2.setTitle("Dr");
        movie2.setTrailerLink("Trailer Linked");
        assertNotEquals(movie, movie2);
    }

    @Test
    void test_not_equals_other() {
        assertFalse(movie.canEqual("Other"));
    }
}

