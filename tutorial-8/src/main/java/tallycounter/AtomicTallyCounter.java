package tallycounter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Atomic Tally Counter class has the similar functionality as the default Tally Counter.
 * However, the queried counter is now not just an ordinary integer. The AtomicInteger from
 * Concurrent package is now being implemented in exchange of the reguler integer.
 * With this Atomic Integer, the instructions that use the Atomic Tally Counter cannot
 * be decoupled. Thus the counter would not be affected by the Thread Race.
 */
public class AtomicTallyCounter {
    private AtomicInteger atomicCounter;

    public AtomicTallyCounter() {
        atomicCounter = new AtomicInteger(0);
    }

    public void increment() {
        atomicCounter.incrementAndGet();
    }

    public void decrement() {
        atomicCounter.decrementAndGet();
    }

    public int value() {
        return atomicCounter.get();
    }

}