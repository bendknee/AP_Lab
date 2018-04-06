import java.util.stream.IntStream;

/**
 * 1st exercise.
 */
public class PrimeChecker {

    public static boolean isPrime(int number) {
        /*boolean divisible = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }

        return number > 1 && !divisible;*/
        /*
        isPrime(1)? false
        isPrime(2)? true
        isPrime(3)? true
        isPrime(4)? false
        isPrime(5)? true
        isPrime(6)? false
        isPrime(7)? true
        isPrime(8)? false
        isPrime(9)? false
        */
        return number > 1 &&
            IntStream.range(2, number)
                     .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(String.format("isPrime(%d)? %b", i, isPrime(i)));
        }
    }
}
