import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieManagerTest {
    @Mock
    private Movie movie1;
    @Mock
    private Movie movie2;

    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        manager = new MovieManager(5);
    }

    @Test
    public void testAddMovie() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        Movie[] movies = manager.findAll();
        assertEquals(2, movies.length);
        assertEquals(movie1, movies[0]);
        assertEquals(movie2, movies[1]);
    }

    @Test
    public void testFindAll() {
        Movie[] movies = manager.findAll();
        assertEquals(0, movies.length);
    }

    @Test
    public void testFindLast_DefaultLimit() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        Movie[] lastMovies = manager.findLast();
        assertEquals(2, lastMovies.length);
        assertEquals(movie2, lastMovies[0]);
        assertEquals(movie1, lastMovies[1]);
    }

    @Test
    public void testFindLast_CustomLimit() {
        Movie movie3 = new Movie("Movie 3");
        Movie movie4 = new Movie("Movie 4");
        Movie movie5 = new Movie("Movie 5");

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);

        Movie[] lastMovies = manager.findLast();
        assertEquals(5, lastMovies.length);
        assertEquals(movie5, lastMovies[0]);
        assertEquals(movie4, lastMovies[1]);
        assertEquals(movie3, lastMovies[2]);
        assertEquals(movie2, lastMovies[3]);
        assertEquals(movie1, lastMovies[4]);
    }
}
