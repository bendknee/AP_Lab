import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PrimeCheckerTest {

    private static final List<Integer> PRIME_NUMBERS = Arrays.asList(2, 3, 5, 7);
    private static final List<Integer> NON_PRIME_NUMBERS = Arrays.asList(1, 4, 15, 39);

    @Before
    public void coverageMain() {
        PrimeChecker.main(new String[]{});
    }

    @Test
    public void testIsPrimeTrueGivenPrimeNumbers() {
        PRIME_NUMBERS.forEach(number -> assertTrue(PrimeChecker.isPrime(number)));
    }

    @Test
    public void testIsPrimeFalseGivenNonPrimeNumbers() {
        NON_PRIME_NUMBERS.forEach(number -> assertFalse(PrimeChecker.isPrime(number)));
    }
}