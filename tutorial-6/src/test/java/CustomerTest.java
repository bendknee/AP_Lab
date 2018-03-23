import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class CustomerTest {

    private Customer customer;
    private Rental rental1;
    private Rental rental2;
    private Movie movie1;
    private Movie movie2;

    @Before
    public void setUp() {
        customer = new Customer("Alice");
        movie1 = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        movie2 = new Movie("Doctor Strange", Movie.NEW_RELEASE);
        rental1 = new Rental(movie1, 3);
        rental2 = new Rental(movie2, 5);
        customer.addRental(rental1);
    }


    @Test
    public void getName() {
        assertEquals("Alice", customer.getName());
    }

    @Test
    public void statementWithSingleMovie() {
        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 3.5"));
        assertTrue(result.contains("1 frequent renter points"));
    }

    @Test
    public void statementWithMultipleMovies() {
        customer.addRental(rental2);
        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(5, lines.length);
        assertTrue(result.contains("Amount owed is 18.5"));
        assertTrue(result.contains("3 frequent renter points"));
    }

    @Test
    public void htmlStatementWithSingleMovie() {
        String result = customer.htmlStatement();
        String[] lines = result.split("<br />");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 3.5"));
        assertTrue(result.contains("1 frequent renter points"));
    }

    @Test
    public void htmlStatementWithMultipleMovies() {
        customer.addRental(rental2);
        String result = customer.htmlStatement();
        String[] lines = result.split("<br />");

        assertEquals(5, lines.length);
        assertTrue(result.contains("Amount owed is 18.5"));
        assertTrue(result.contains("3 frequent renter points"));
    }

}