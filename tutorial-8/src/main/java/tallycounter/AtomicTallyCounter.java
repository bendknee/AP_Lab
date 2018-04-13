package tallycounter;

import java.util.concurrent.atomic.AtomicInteger;

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