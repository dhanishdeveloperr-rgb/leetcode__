import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private final int n;

    private final Semaphore zeroTurn = new Semaphore(1);
    private final Semaphore oddTurn = new Semaphore(0);
    private final Semaphore evenTurn = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int number = 1; number <= n; number++) {
            zeroTurn.acquire();

            printNumber.accept(0);

            if (number % 2 == 1) {
                oddTurn.release();
            } else {
                evenTurn.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int number = 2; number <= n; number += 2) {
            evenTurn.acquire();

            printNumber.accept(number);

            zeroTurn.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int number = 1; number <= n; number += 2) {
            oddTurn.acquire();

            printNumber.accept(number);

            zeroTurn.release();
        }
    }
}