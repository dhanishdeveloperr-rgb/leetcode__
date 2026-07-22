import java.util.function.IntConsumer;

class FizzBuzz {

    private final int n;
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current <= n &&
                        !(current % 3 == 0 && current % 5 != 0)) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printFizz.run();
                current++;
                notifyAll();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current <= n &&
                        !(current % 5 == 0 && current % 3 != 0)) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printBuzz.run();
                current++;
                notifyAll();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current <= n && current % 15 != 0) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printFizzBuzz.run();
                current++;
                notifyAll();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current <= n &&
                        (current % 3 == 0 || current % 5 == 0)) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printNumber.accept(current);
                current++;
                notifyAll();
            }
        }
    }
}