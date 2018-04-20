import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class RentalTest {
    private Movie movie;
    private Rental rental;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rental = new Rental(movie, 4);
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void getDaysRented() {
        assertEquals(4, rental.getDaysRented());
    }

    @Test
    public void calculateAmount() {
        assertEquals(5, rental.getCharge(), 0.001);

        rental.getMovie().setPriceCode(Movie.NEW_RELEASE);
        assertEquals(12, rental.getCharge(), 0.001);

        rental.getMovie().setPriceCode(Movie.CHILDREN);
        assertEquals(3, rental.getCharge(), 0.001);
    }

}