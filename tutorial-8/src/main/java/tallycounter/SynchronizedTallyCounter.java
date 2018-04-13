package tallycounter;

/**
 * The Synchronized Tally Counter class has the similar functionality as the default Tally Counter.
 * However, each method has the 'synchronized' signature which means that every another instance
 * requests to use the method, that instance has to wait until all previous instance
 * that used the method has finished using it. That way, the counter integer would not be affected
 * by a Thread Race. The synchronized signature maintains consistency.
 */
public class SynchronizedTallyCounter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public synchronized int value() {
        return counter;
    }

}