import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
    }


    @Test
    public void getTitle() {
        assertEquals("Who Killed Captain Alex?", movie.getTitle());
    }

    @Test
    public void setTitle() {
        movie.setTitle("Bad Black");
        assertEquals("Bad Black", movie.getTitle());
    }

    @Test
    public void getPriceCode() {
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

    @Test
    public void setPriceCode() {
        movie.setPriceCode(Movie.CHILDREN);

        assertEquals(Movie.CHILDREN, movie.getPriceCode());
    }

    @Test
    public void hashCodeTest() {
        int hash = Objects.hash("Who Killed Captain Alex?", Movie.REGULAR);
        assertEquals(hash, movie.hashCode());
    }


    @Test
    public void equals() {
        assertFalse(movie.equals(null));
        assertFalse(movie.equals(new Movie("Black Panther", Movie.NEW_RELEASE)));
        assertTrue(movie.equals(new Movie("Who Killed Captain Alex?", Movie.REGULAR)));
        assertTrue(movie.equals(movie));
    }

}